package com.encore.board.Author.Dto;

import com.encore.board.Author.domain.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorDetailResDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long posts;
    private String role;
    private long postCount;
    private LocalDateTime createdTime;
}
