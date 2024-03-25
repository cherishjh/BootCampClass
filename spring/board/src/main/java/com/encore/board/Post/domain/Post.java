package com.encore.board.Post.domain;

import com.encore.board.Author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 3000, nullable = false)
    private String contents;

    //복습(2024.01.25)
    //author_id 는 DB의 컬럼명, 별다른 option 없으면 author 의 pk에 fk 설정
    // fetch = FetchType.LAZY  -> 지연로딩
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    //@JoinColumn(nullable = false, name="author_email", referenceColumnName="email)
    private Author author;


    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedTime;

    private String appointment;
    private LocalDateTime appointmentTime;

  /*  @Builder
    public Post(String title, String contents,Author author,LocalDateTime appointmentTime){
        this.title= title;
        this.contents=contents;
        this.author=author;
        this.appointmentTime=appointmentTime;
//        author 객체의 post를 초기화시켜준 뒤
//        this.author.getPosts().add(this);
    }*/

    public void updatePost(String title, String contents){
        this.title=title;
        this.contents=contents;
    }

 /*   public void addPost(){
        this.author.getPosts().add(this);
    }*/

    public void updateAppointment(String appointment){
        this.appointment= appointment;
    }
}
