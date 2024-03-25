package com.encore.basic.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
// @AllArgsConstructor : 모든 매개변수를 넣은 생성자 자동 생성
//entity 어노테이션을 통해 mariadb의 테이블 및 칼럼을 자동 생성
//class 명은 테이블명, 변수명은 컬럼명
@Entity
@NoArgsConstructor      //리플랙션 기술을 통해서 런타임 상황에서 변수에 접근할때 객체를 만들어주긴 해야해서 사용; 아니면 오류 남
public class Member {
    @Setter
    @Id  //pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //identity= auto-increment 설정, auto=JPA구현체가 자동으로 적절한 키 생성 전략 선택.
    private int id;
//    String 은 DB에 varchar로 변환이 된다.
    @Setter
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    @Setter
    private String password;
    @Setter
    //@Column(name="created_time")        // name 옵션을 통해 DB에는 컬럼명 별도 지정 가능
    @Column(name="created_time")
    // name 옵션을 통해 DB에는 컬럼명 별도 지정 가능
    @CreationTimestamp
    private LocalDateTime create_time;
    //update time
    @UpdateTimestamp
    private LocalDateTime updatedTime;



    public Member(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public void updateMember(String name, String password){

    }

//    public Member(){
//
//    }
}
