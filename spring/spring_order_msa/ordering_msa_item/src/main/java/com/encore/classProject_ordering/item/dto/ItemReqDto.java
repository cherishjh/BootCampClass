package com.encore.classProject_ordering.item.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ItemReqDto {
    private String name;
    private String category;
    private int price;
    private Long stockQuantity;
    private MultipartFile itemImage;


}
