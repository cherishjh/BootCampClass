package com.encore.board.Author.domain;


import com.encore.board.Post.domain.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
/*@NoArgsConstructor
@Builder*/
//위와 같이 모든 매개변수가 있는 생성자를 생성하는 annotation과 builder를 클래스에 붙여
//모든 매개변수가 있는 생성자 위에 builder annotation을 붙인 효과가 있다.
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false, length=20)
    @Setter
    private String name;
    @Column(nullable = false, length=20, unique = true)
    private String email;
    @Column(nullable = false)
    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    //author을 조회할때 post 객체가 필요시 선언
    //mappedBy로 연관관계의 주인을 명시하고, fk를 관리하는 변수명을 명시      연관관계의 주인은 fk를 관리하는
    //1:1관계일 경우 @OneToOne도 존재
    @OneToMany(mappedBy = "author", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
//    @Setter  // cascade.persist을 위한 test
    private List<Post> posts;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime updatedTime;

    //builder annotation을 통해 빌더 패턴으로 객체 생성
    //매개변수의 셋팅 순서, 매개변수의 개수 등을 유연하게 셋팅할 수 있다.
    //
    @Builder
    public Author(String name, String email, String password, Role role, List<Post> posts){
        this.name=name;
        this.email=email;
        this.password=password;
        this.role=role;
        this.posts=posts;
    }

    public void updateAuthor(String name, String password){   // **
        this.name=name;
        this.password=password;
    }


}
