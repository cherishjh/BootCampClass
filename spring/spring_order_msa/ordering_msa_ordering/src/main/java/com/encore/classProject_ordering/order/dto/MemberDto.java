package com.encore.classProject_ordering.order.dto;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
// MemberResponseDto
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String street;
    private String zipcode;
    private int orderCount;
//    private List<Ordering> orderingList;

//    public static MemberResponseDto toMemberResponseDto(Member member){
//        MemberResponseDtoBuilder builder= MemberResponseDto.builder();
//        builder.id(member.getId());
//        builder.name(member.getName());
//        builder.email(member.getEmail());
////        builder.orderCount= member.getOrderings().size();
//        Address address= member.getAddress();
//        if(address!=null){
//            builder.city(address.getCity());
//            builder.street(address.getStreet());
//            builder.zipcode(address.getZipcode());
//        }
//        return builder.build();
//    }



}
