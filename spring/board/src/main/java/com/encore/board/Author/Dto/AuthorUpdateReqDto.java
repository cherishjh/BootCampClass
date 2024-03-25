package com.encore.board.Author.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthorUpdateReqDto {
    private String name;
    private String password;
}
