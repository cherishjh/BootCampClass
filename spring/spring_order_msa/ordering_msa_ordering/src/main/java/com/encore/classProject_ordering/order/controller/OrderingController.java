package com.encore.classProject_ordering.order.controller;

import com.encore.classProject_ordering.common.CommonResponse;
import com.encore.classProject_ordering.order.domain.Ordering;
import com.encore.classProject_ordering.order.dto.OrderReqDto;
import com.encore.classProject_ordering.order.dto.OrderResDto;
import com.encore.classProject_ordering.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderingController {

    private final OrderService orderService;

    @Autowired
    public OrderingController(OrderService orderService) {
        this.orderService = orderService;
    }


     /* @PostMapping("/order/new")
      public void newOrder(OrderReqDto orderReqDto){
          Ordering ordering= Ordering.builder().build();
          orderRepository.save(ordering);
          for(int i=0; i<orderReqDto.getItemIds().size(); i++){
              Long id= orderReqDto.getItemIds().get(i);
              Long count=orderReqDto.getCounts().get(i);
              OrderItem orderItem= OrderItem.builder().build();
              orderItemRepository.save(orderItem);
          }
      }*/
  /*   @PostMapping("/order/new")
     public ResponseEntity<CommonResponse> orderingCreate(@RequestBody OrderReqDto orderReqDto) {
         System.out.println(orderReqDto);
         Ordering ordering = orderService.create(orderReqDto);
         return new ResponseEntity<>(new CommonResponse
                 (HttpStatus.CREATED, "item succesfully create", ordering.getId()),
                 HttpStatus.CREATED);
     }*/

    //vue에서 데이터 이름 맞춰줄때 -> orderReqDto를 list로 변환
     @PostMapping("/order/new")
     public ResponseEntity<CommonResponse> orderingCreate(
             @RequestBody List<OrderReqDto> orderReqDtos ,
             @RequestHeader("myEmail") String email
     ) {
         System.out.println(orderReqDtos);
         Ordering ordering = orderService.create(orderReqDtos, email);
         return new ResponseEntity<>(new CommonResponse
                 (HttpStatus.CREATED, "item succesfully create", ordering.getId()),
                 HttpStatus.CREATED);
     }



     //annotation을 통해 권한체크 할 수 있음
//     @PreAuthorize("hasRole('ADMIN') or #email ==  authentication.principal.username")
//     @DeleteMapping("/order/{orderId}/cancel")
//     public ResponseEntity<CommonResponse> orderCancel (@PathVariable("orderId") Long id){
//         Order order= orderService.findById(id);
//         Ordering ordering= orderService.cancel(id);
//         return new ResponseEntity<>(new CommonResponse
//                 (HttpStatus.OK, "order successfully canceled", ordering.getId()),
//                 HttpStatus.OK);
//     }

     //전체 주문 목록 확인
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/orders")
//    public List<OrderResDto> getOrders(){
//      return orderService.findAll();
//    }


}
