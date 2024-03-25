package com.encore.board.Post.Repository;

import com.encore.board.Author.domain.Author;
import com.encore.board.Post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByAuthor_id(long author_id);
//    List<Post> findAllByOrderByCreatedTimeDesc();
    //Pageable 객체 안에 pageNumber(page=1), page 마다 개수(size=10), 정렬(sort=createdTime,desc)
    //Page=List<Post> + 해당 Page 의 각종 정보
    Page<Post> findAll(Pageable pageable);

    Page<Post> findByAppointment(String appointment, Pageable pageable);



//    Select p.* from post p left join author on p.author_id= a.id;   mariaDB 쿼리
    //아래 jpql의 join문은 author 객체를 통해 post를 스크리닝하고 싶은 상황에 적합
    @Query("select p from Post p left join p.author")   //jpql 문
    List<Post> findAllJoin();

    //    Select p.*, a.* from post p left join author a on p.author_id= a.id;   mariaDB 쿼리
    @Query("select p from Post p left join fetch p.author")
    List<Post> findAllFetchJoin();


}
