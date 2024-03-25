package com.encore.classProject_ordering.member.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginReqDto {
    @NotEmpty(message = "email is essential" )           //
    @Email(message = "email is not valid")
    private String email;
    @NotEmpty(message = "password is essential" )
    @Size(min= 4, message = "password is too short")
    private String password;
}
