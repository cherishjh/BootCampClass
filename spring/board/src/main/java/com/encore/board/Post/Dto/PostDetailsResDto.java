package com.encore.board.Post.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDetailsResDto {
    private long id;
    private String title;
    private String contents;
    private LocalDateTime created_time;
}
