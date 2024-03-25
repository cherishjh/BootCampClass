package com.encore.classProject_ordering.member.dto;


import com.encore.classProject_ordering.member.domain.Address;
import com.encore.classProject_ordering.member.domain.Member;
import com.encore.classProject_ordering.order.domain.Ordering;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String street;
    private String zipcode;
    private int orderCount;
    private List<Ordering> orderingList;

    public static MemberResponseDto toMemberResponseDto(Member member){
        MemberResponseDtoBuilder builder= MemberResponseDto.builder();
        builder.id(member.getId());
        builder.name(member.getName());
        builder.email(member.getEmail());
        builder.orderCount= member.getOrderings().size();
        Address address= member.getAddress();
        if(address!=null){
            builder.city(address.getCity());
            builder.street(address.getStreet());
            builder.zipcode(address.getZipcode());
        }
        return builder.build();
    }



}
