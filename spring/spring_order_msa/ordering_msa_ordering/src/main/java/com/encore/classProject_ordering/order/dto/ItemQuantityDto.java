package com.encore.classProject_ordering.order.dto;

//import com.encore.classProject_ordering.member.domain.Address;
//import com.encore.classProject_ordering.member.domain.Member;
//import com.encore.classProject_ordering.member.dto.MemberResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemQuantityDto {
    private Long id;
    private Long stockQuantity;


}
