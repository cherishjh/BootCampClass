package com.encore.board.Author.Controller;

import com.encore.board.Author.Dto.*;
import com.encore.board.Author.Service.AuthorService;
import com.encore.board.Author.domain.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@Slf4j
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }

    @GetMapping("/author/register")
    public String authorRegister(){
        return "author/author-register";
    }

   /* @PostMapping("/author/register")
    public String authorSave(AuthorSaveReqDto authorSaveReqDto){
        authorService.save(authorSaveReqDto);
        return  "redirect:/author/list";
    }*/
   @PostMapping("/author/register")
   public String authorSave(Model model, AuthorSaveReqDto authorSaveReqDto){
       try{
           authorService.save(authorSaveReqDto);
           return  "redirect:/author/list";
       } catch (IllegalArgumentException e){
           model.addAttribute("errorMessage",e.getMessage());
           log.error(e.getMessage());
           return "author/author-register";
       }
   }

   //로그인 화면
    @GetMapping("/author/login-page")
    public String authorLogin(){
       return "author/login-page";
    }

    //로그인
  /*  @PostMapping("/doLogin")
    public String signIn(Model model, AuthorLoginReqDto authorLoginReqDto){

    }*/


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/author/list")
    public String authorList(Model model){
        List<AuthorListResDto> authorListResDtoList= authorService.findAll();
        model.addAttribute("authorList",authorListResDtoList);
      return "author/author-list";
    }

    @GetMapping("/author/detail/{id}")
    public String authorDetail(@PathVariable long id, Model model){
        AuthorDetailResDto authorDetailResDto= null;
        try{
            authorDetailResDto = authorService.findAuthorDetail(id);
            model.addAttribute("author", authorDetailResDto);
            return "/author/author-detail";
        } catch (EntityNotFoundException e){
            log.error(e.getMessage());
        }
        return "redirect:/author/list";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/author/delete/{id}")
    public String delete(@PathVariable long id){
        authorService.delete(id);
        return "redirect:/author/list";
    }

    @PostMapping("/author/{id}/update")
    public String update(@PathVariable long id, AuthorUpdateReqDto authorUpdateReqDto){
        authorService.update(id, authorUpdateReqDto);
        return "redirect:/author/detail/"+id ;
    }

//    entity 순환참조 이슈 test
    @GetMapping("/author/{id}/circle/entity")
    @ResponseBody
    //연관관계가 있는 author엔티티를 json으로 직렬화하게 될 경우
    //순환참조 이슈가 발생하므로 dto 사용
    public Author circleIssueTest1(@PathVariable long id){
        return authorService.findById(id);
    }

    @GetMapping("/author/{id}/circle/dto")
    @ResponseBody
    public AuthorDetailResDto circleIssueTest2(@PathVariable long id){
        return authorService.findAuthorDetail(id);
    }
}
