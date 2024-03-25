package com.encore.classProject_ordering.order.service;


import com.encore.classProject_ordering.common.CommonResponse;
import com.encore.classProject_ordering.order.domain.OrderItem;
import com.encore.classProject_ordering.order.domain.Ordering;
import com.encore.classProject_ordering.order.dto.ItemDto;
import com.encore.classProject_ordering.order.dto.ItemQuantityDto;
import com.encore.classProject_ordering.order.dto.MemberDto;
import com.encore.classProject_ordering.order.dto.OrderReqDto;
import com.encore.classProject_ordering.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final String MEMBER_API = "http://member-service/";
    private final String ITEM_API = "http://item-service/";

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Ordering create(List<OrderReqDto> orderReqDtos, String email) {
        String MemberUrl = MEMBER_API + "member/findByEmail?email="+email;

        MemberDto member = restTemplate.getForObject(MemberUrl, MemberDto.class);
        Ordering ordering = Ordering.builder().memberId(member.getId()).build();

        // Ordering 객체가 생성될 때 OrderingItem 객체도 함께 생성 : cascading
//        List<ItemQuantityDto> list = new ArrayList<>();
        for (OrderReqDto dto : orderReqDtos) {
            OrderItem orderItem = OrderItem.builder()
                    .itemId(dto.getItemId())
                    .quantity(dto.getCount())
                    .ordering(ordering)
                    .build();
            ordering.getOrderItems().add(orderItem);
//            "item/updateQuantity"
            String ItemUrl = ITEM_API + "item/"+ dto.getItemId();
            ResponseEntity<ItemDto> itemDto = restTemplate.getForEntity(ItemUrl, ItemDto.class);

            if(itemDto.getBody().getStockQuantity() - dto.getCount() < 0) {
                throw new IllegalArgumentException("재고가 부족합니다.");
            }
            Long newQuantity = itemDto.getBody().getStockQuantity() - dto.getCount();
            ItemQuantityDto updateDto = new ItemQuantityDto();
            updateDto.setId(dto.getItemId());
            updateDto.setStockQuantity(newQuantity);
//            list.add(updateDto);
//            Ordering order = orderRepository.save(ordering);
            String ItemPatchUrl = ITEM_API + "item/updateQuantity";
//            HttpEntity<List<ItemQuantityDto>> httpEntity = new HttpEntity<>(list);
            HttpEntity<ItemQuantityDto> httpEntity = new HttpEntity<>(updateDto);
            ResponseEntity<CommonResponse> response = restTemplate
                    .exchange(ItemPatchUrl, HttpMethod.POST, httpEntity, CommonResponse.class);
            log.info(response.getBody().getMessage());
        }

       return orderRepository.save(ordering);//        return null;
    }


    //주문 취소
//    public Ordering cancel(Long id) throws AccessDeniedException {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email= authentication.getName();
//        List<GrantedAuthority> role_list= (List<GrantedAuthority>) authentication.getAuthorities();
//        Ordering ordering= orderRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("주문하신 내역이 없습니다."));
//        if(!ordering.getMember().getEmail().equals(email) &&
//                !authentication.getAuthorities().contains((new SimpleGrantedAuthority("ROLE_ADMIN")))){
//            throw new AccessDeniedException("권한이 없습니다.");
//        }
//        if(ordering.getOrderStatus()== OrderStatus.CANCELED){
//            throw new IllegalArgumentException("이미 취소된 주문입니다.");
//        }
//        ordering.cancelOrderStatus();
//        for(OrderItem orderItem: ordering.getOrderItems()){
//            orderItem.getItem().updateStockQuantity(
//                    orderItem.getItem().getStockQuantity()+orderItem.getQuantity());
//        }
//        return orderRepository.save(ordering);
//    }

    //전체 주문 조회
//    public List<OrderResDto> findAll(){
//        List<Ordering> orderings=orderRepository.findAll();
//        return orderings.stream().map(a->OrderResDto.toDto(a)).collect(Collectors.toList());
//    }
//
//
//    public List<OrderResDto> findByMember(Long id) {
//        Member member= memberRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("회원이 아닙니다."));
//        List<Ordering> orderings= member.getOrderings();
////        List<Ordering> orderings= orderRepository.findByMemberId(id);
////        System.out.println(orderings);
//        return orderings.stream().map(a-> OrderResDto.toDto(a)).collect(Collectors.toList());
//    }
//
//    public List<OrderResDto> findMyOrders(Long memberId) {
//        List<Ordering> orderings= orderRepository.findByMemberId(memberId);
//        return  orderings.stream().map(a->OrderResDto.toDto(a)).collect(Collectors.toList());
//    }
}
