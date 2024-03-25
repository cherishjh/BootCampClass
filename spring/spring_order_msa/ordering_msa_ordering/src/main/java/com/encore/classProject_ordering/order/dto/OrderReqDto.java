package com.encore.classProject_ordering.order.dto;

import lombok.Data;

import java.util.List;

/*@Data
public class OrderReqDto {
    private List<Long> itemIds;
    private List<Long> counts;
}*/

//@Data
//public class OrderReqDto {
//    private List<OrderReqItemDto> orderReqItemDtos ;
//
//    @Data
//    public static class OrderReqItemDto{
//        private Long itemId;
//        private Long count;
//    }
//}


@Data
public class OrderReqDto {
        private Long itemId;
        private Long count;
}



