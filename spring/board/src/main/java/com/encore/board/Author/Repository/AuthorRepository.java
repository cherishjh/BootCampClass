package com.encore.board.Author.Repository;

import com.encore.board.Author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository <Author,Long> {
//    findby 컬럼명(컬럼명A and B) 규칙으로 자동으로 where 조건문 메서드 생성
//
    Optional<Author> findByEmail(String email);


}


