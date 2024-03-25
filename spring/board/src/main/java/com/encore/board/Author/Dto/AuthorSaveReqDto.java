package com.encore.board.Author.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor //?????
@Data
public class AuthorSaveReqDto {
    private String name;
    private String email;
    private String password;
    private String role;
}
