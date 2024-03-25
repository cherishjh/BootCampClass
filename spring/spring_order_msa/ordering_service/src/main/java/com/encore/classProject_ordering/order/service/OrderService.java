package com.encore.classProject_ordering.order.service;

import com.encore.classProject_ordering.item.domain.Item;
import com.encore.classProject_ordering.item.repository.ItemRepository;
import com.encore.classProject_ordering.member.domain.Member;
import com.encore.classProject_ordering.member.repository.MemberRepository;
import com.encore.classProject_ordering.order.domain.OrderStatus;
import com.encore.classProject_ordering.order.domain.Ordering;
import com.encore.classProject_ordering.order.dto.OrderReqDto;
import com.encore.classProject_ordering.order.dto.OrderResDto;
import com.encore.classProject_ordering.order.repository.OrderRepository;
import com.encore.classProject_ordering.order_item.domain.OrderItem;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, MemberRepository memberRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
    }

//    public Ordering create(OrderReqDto orderReqDto){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email= authentication.getName();
//        Member member= memberRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
//
//        Ordering ordering= Ordering.builder().member(member).build();
////      ordering 객체가 생성될때 orderingItem 객체도 함께 생성 : cascading
//        for(OrderReqDto.OrderReqItemDto orderReqItemDto :orderReqDto.getOrderReqItemDtos()) {
//            Item item= itemRepository.findById(orderReqItemDto.getItemId()).orElseThrow(()->new EntityNotFoundException("item not found"));
//            OrderItem orderItem = OrderItem.builder()
//                    .quantity(orderReqItemDto.getCount())
//                    .item(item)
//                    .ordering(ordering)
//                    .build();
//            ordering.getOrderItems().add(orderItem);
//            if(item.getStockQuantity()-orderReqItemDto.getCount()<0){
//                throw new IllegalArgumentException("주문 수량이 재고 수량보다 많습니다");
//            }
//            orderItem.getItem().updateStockQuantity(item.getStockQuantity()-orderReqItemDto.getCount());
//        }
//        return orderRepository.save(ordering);
//    }

    public Ordering create(List<OrderReqDto> orderReqDtos){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        Member member= memberRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);

        Ordering ordering= Ordering.builder().member(member).build();
//      ordering 객체가 생성될때 orderingItem 객체도 함께 생성 : cascading
        for(OrderReqDto dto :orderReqDtos) {
            Item item= itemRepository.findById(dto.getItemId()).orElseThrow(()->new EntityNotFoundException("item not found"));
            OrderItem orderItem = OrderItem.builder()
                    .quantity(dto.getCount())
                    .item(item)
                    .ordering(ordering)
                    .build();
            ordering.getOrderItems().add(orderItem);
            if(item.getStockQuantity()-dto.getCount()<0){
                throw new IllegalArgumentException("주문 수량이 재고 수량보다 많습니다");
            }
            orderItem.getItem().updateStockQuantity(item.getStockQuantity()-dto.getCount());
        }
        return orderRepository.save(ordering);
    }

    //주문 취소
    public Ordering cancel(Long id) throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        List<GrantedAuthority> role_list= (List<GrantedAuthority>) authentication.getAuthorities();
        Ordering ordering= orderRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("주문하신 내역이 없습니다."));
        if(!ordering.getMember().getEmail().equals(email) &&
                !authentication.getAuthorities().contains((new SimpleGrantedAuthority("ROLE_ADMIN")))){
            throw new AccessDeniedException("권한이 없습니다.");
        }
        if(ordering.getOrderStatus()== OrderStatus.CANCELED){
            throw new IllegalArgumentException("이미 취소된 주문입니다.");
        }
        ordering.cancelOrderStatus();
        for(OrderItem orderItem: ordering.getOrderItems()){
            orderItem.getItem().updateStockQuantity(
                    orderItem.getItem().getStockQuantity()+orderItem.getQuantity());
        }
        return orderRepository.save(ordering);
    }

    //전체 주문 조회
    public List<OrderResDto> findAll(){
        List<Ordering> orderings=orderRepository.findAll();
        return orderings.stream().map(a->OrderResDto.toDto(a)).collect(Collectors.toList());
    }


    public List<OrderResDto> findByMember(Long id) {
        Member member= memberRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("회원이 아닙니다."));
        List<Ordering> orderings= member.getOrderings();
//        List<Ordering> orderings= orderRepository.findByMemberId(id);
//        System.out.println(orderings);
        return orderings.stream().map(a-> OrderResDto.toDto(a)).collect(Collectors.toList());
    }

    public List<OrderResDto> findMyOrders() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Member member= memberRepository.findByEmail(email).orElseThrow(()-> new EntityNotFoundException("not found"));
        List<Ordering> orderings= member.getOrderings();
        return  orderings.stream().map(a->OrderResDto.toDto(a)).collect(Collectors.toList());
    }
}
