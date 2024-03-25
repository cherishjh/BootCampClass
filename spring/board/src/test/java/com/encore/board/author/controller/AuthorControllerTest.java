/*
package com.encore.board.author.controller;

import com.encore.board.Author.Controller.AuthorController;
import com.encore.board.Author.Dto.AuthorDetailResDto;
import com.encore.board.Author.Service.AuthorService;
import com.encore.board.Author.domain.Author;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//WebMvcTest를 이용해서 controller 계층을 테스트, 모든 스프링빈을 생성하고 주입하지 않음
//@WebMvcTest(AuthorController.class)

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @Test
    @WithMockUser //security 의존성 추가 필요
    void authorDetailTest() throws Exception {
        AuthorDetailResDto authorDetailResDto = new AuthorDetailResDto();
        authorDetailResDto.setName("testname");
        authorDetailResDto.setEmail("test123@naver.com");
        authorDetailResDto.setPassword("1234");
        Mockito.when(authorService.findAuthorDetail(1L)).thenReturn(authorDetailResDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/author/1/circle/dto"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name",authorDetailResDto.getName()));
    }
}
*/
