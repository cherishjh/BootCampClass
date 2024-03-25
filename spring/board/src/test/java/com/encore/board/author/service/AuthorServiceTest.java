package com.encore.board.author.service;

import com.encore.board.Author.Dto.AuthorDetailResDto;
import com.encore.board.Author.Dto.AuthorUpdateReqDto;
import com.encore.board.Author.Repository.AuthorRepository;
import com.encore.board.Author.Service.AuthorService;
import com.encore.board.Author.domain.Author;
import com.encore.board.Post.domain.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;

    @Autowired


    //가짜 객체를 만드는 작업을 목킹이라 한다.
    @MockBean
    private AuthorRepository authorRepository;


    @Test
    void updateTest(){
        Long authorId = 1L;
        Author author = Author.builder()
                .name("test1")
                .email("test1@naver.com")
                .password("1234")
                .build();
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        AuthorUpdateReqDto authorUpdateReqDto = new AuthorUpdateReqDto();
        authorUpdateReqDto.setName("test2");
        authorUpdateReqDto.setPassword("4321");
        authorService.update(authorId, authorUpdateReqDto);
        Assertions.assertEquals(author.getName(), authorUpdateReqDto.getName());
        Assertions.assertEquals(author.getPassword(), authorUpdateReqDto.getPassword());

        /*Author author_new = Author.builder()
                .name("test1")
                .email("test1@naver.com")
                .password("1234")
                .build();
        Mockito.when(authorRepository.save(author_new));*/

    }

    @Test
    void findAllTest(){

//        Mock repository 기능 구현
        List<Author> authors= new ArrayList<>();
        authors.add(new Author());
        authors.add(new Author());
        Mockito.when(authorRepository.findAll()).thenReturn(authors);
      /*  for(Author author: authorRepository.findAll()){
            System.out.println(author.getId());
        }*/

//        검증
        Assertions.assertEquals(authors.size(),authorService.findAll().size());

    }

    @Test
    void findAuthorDetailTest(){
        Long authorId = 1L;
        List<Post> posts = new ArrayList<>();
        Post post = Post.builder()
                .title("hello")
                .contents("hello word")
                .build();
        posts.add(post);
        Author author = Author.builder()
                .name("test1")
                .email("test1@naver.com")
                .password("1234")
                .posts(posts)
                .build();
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        AuthorDetailResDto authorDetailResDto =  authorService.findAuthorDetail(authorId);
        Assertions.assertEquals(author.getName(), authorDetailResDto.getName());
        Assertions.assertEquals(author.getPosts().size(), authorDetailResDto.getPostCount());
        Assertions.assertEquals("일반유저", authorDetailResDto.getRole());
    }




}
