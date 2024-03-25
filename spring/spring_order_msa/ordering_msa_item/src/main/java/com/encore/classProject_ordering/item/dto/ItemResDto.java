package com.encore.classProject_ordering.item.dto;

//import com.encore.classProject_ordering.member.domain.Address;
//import com.encore.classProject_ordering.member.domain.Member;
//import com.encore.classProject_ordering.member.dto.MemberResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResDto {
    private Long id;
    private String name;
    private String category;
    private int price;
    private Long stockQuantity;
    private String imagePath;

}
