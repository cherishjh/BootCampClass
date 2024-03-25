package com.encore.board.Post.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostListResDto {
    private long id;
    private String title;
    private String author_email;
/*    private String appointment;
    private LocalDateTime appointmentTime;*/
//    private LocalDateTime created_time;

}
