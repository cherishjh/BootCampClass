package com.encore.board.author.repository;


import com.encore.board.Author.Repository.AuthorRepository;
import com.encore.board.Author.Service.AuthorService;
import com.encore.board.Author.domain.Author;
import com.encore.board.Author.domain.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.graphql.AutoConfigureGraphQl;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;


//save기능이 정상인지 아닌지 확인하려면 -> DB에 넣어봐야 함

//DataJpaTest annotation: 매 테스트가 종료되면 자동으로 DB 원상복귀 ; 자동 rollback 기능 지원
    //모든 스프링 빈을 생성하지 않고 DB 테스트 특화 annotation
//SpringBootTest annotation: 자동 rollback 안됨, 별도의 rollback 코드 필요
    //SpringBootTest annotation은 실제 스프링 실행과 동일하게 스프링빈 생성


//@ActiveProfiles("test") : yml 파일도 test용으로 돌리고 싶을때, application-test.yml 파일을 찾아 설정값 셋팅; - 뒤에 이름만 인식
//replace= AutoConfigureTestDatabase.Replace.ANY:H2 DB (spring 내장 인메모리, test용도로)가 기본 설정
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
//@SpringBootTest
//@Transactional   //SpringBootTest 쓸 때 rollback
public class AuthorRepositoryTest {
   @Autowired
    private AuthorRepository authorRepository;

   @Test
    public void authorSaveTest(){
//       객체 만들고 save -> 재조회 -> 만든 객체와 비교
//       findByEmail로 조회 (id는 사용자가 자신의 id를 모르기 때문)

//       1.준비 (prepare, given)   given,when,then 패턴
       Author author = Author.builder()
               .email("testcode4@naver.com")
               .name("test9")
               .password("1234")
               .role(Role.ADMIN)
               .build();
//       2.실행(excute, when)
       authorRepository.save(author);
       Author authorDb= authorRepository.findByEmail("testcode4@naver.com").orElse(null);

//       3.검증(then)
//       Assertions 클래스의 기능을 통해 오류 원인 파악, null 처리, 가시적으로 성공/실패 여부 확인
       Assertions.assertEquals(author.getEmail(),authorDb.getEmail());
   }


}
