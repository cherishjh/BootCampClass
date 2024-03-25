package com.encore.classProject_ordering.member.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class MemberCreateReqDto {
    @NotEmpty(message = "name is essential" )           //
    private String name;
    @NotEmpty(message = "email is essential" )           //
    @Email(message = "email is not valid")
    private String email;
    @NotEmpty(message = "password is essential" )
    @Size(min= 4, message = "password is too short")
    private String password;
//    private String role;              사용자가 자신의 role을 결정하는 것이 맞지 않아서
    private String city;
    private String street;
    private String zipcode;



}
