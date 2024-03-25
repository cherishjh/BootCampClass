package com.encore.board.Post.Service;


import com.encore.board.Post.Repository.PostRepository;
import com.encore.board.Post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@Transactional
public class PostScheduler {
    private final PostRepository postRepository;

    @Autowired
    public PostScheduler(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

//    초 분 시간 일 월 요일 형태로 스케줄링 설정
//    * : 매 초(분/시 등)을 의미
//    특정 숫자: 특정 숫자의 초(분/시 등)을 의미
//    0/ 특정 숫자: 특정 숫자 마다
//    ex) 0 0 * * * *: 매일 0분 0초에 스케줄링 시작
//    ex) 0 0/1 * * * *: 매일 1분마다 0초에 스케줄링 시작
//    ex) 0/1 * * * * : 매 초 마다
//    ex) 0 0 11 * * * : 매일 오전 11시에 스케줄링
//
//    @Scheduled(cron="0 0/1 * * * *")
    public void postSchedule(){
        System.out.println("스케줄러 시작");
        Page<Post> posts= postRepository.findByAppointment("Y", Pageable.unpaged());
        for(Post p: posts.getContent()){
            if(p.getAppointmentTime().isBefore(LocalDateTime.now())){
                p.updateAppointment(null);
//                postRepository.save(p);
            }
        }
        System.out.println("스케줄러 끝");
    }
}
