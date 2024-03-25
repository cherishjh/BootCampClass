package com.encore.board.Author.Dto;

import com.encore.board.Author.domain.Role;
import lombok.Data;

@Data
public class AuthorListResDto {
    private Long id;
    private String name;
    private String email;

}
