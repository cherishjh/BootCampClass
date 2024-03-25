package com.encore.board.Post.Controller;

import com.encore.board.Author.Dto.AuthorDetailResDto;
import com.encore.board.Author.Dto.AuthorListResDto;
import com.encore.board.Author.Dto.AuthorSaveReqDto;
import com.encore.board.Author.Dto.AuthorUpdateReqDto;
import com.encore.board.Post.Dto.PostDetailsResDto;
import com.encore.board.Post.Dto.PostListResDto;
import com.encore.board.Post.Dto.PostSaveReqDto;
import com.encore.board.Post.Dto.PostUpdateReqDto;
import com.encore.board.Post.Service.PostService;
import com.encore.board.Post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }

    /*@GetMapping("/list")
    public String getPostList(Model model){
        List<PostListResDto> postListResDtoList= postService.findAll();
        model.addAttribute("postList",postListResDtoList);
        return "post/post-list";
    }*/
 /*   @GetMapping("/list/json")
//    localhost:8080/post/list?size=xx&page=xx&&sort=xx,desc
    @ResponseBody
    public Page<PostListResDto> postList(Pageable pageable){
        Page<PostListResDto> postListResDtoList= postService.findAllJson(pageable);
        return postListResDtoList;
    }
*/

    @GetMapping("/list")
    public String postList(Model model, @PageableDefault(size=4,sort = "createdTime",direction= Sort.Direction.DESC) Pageable pageable){
        Page<PostListResDto> postListResDtoList= postService.findByAppointment(pageable);
        model.addAttribute("postList",postListResDtoList);
        return "post/post-list";
    }

    @GetMapping("/details/{id}")
    public String postDetail(@PathVariable long id, Model model){
        PostDetailsResDto postDetailsResDto = postService.findAuthorDetail(id);
        model.addAttribute("post", postDetailsResDto);

        return "post/post-detail";
    }


    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, PostUpdateReqDto postUpdateReqDto){
//        System.out.println("heer");    log 확인할때 이런식으로 확인
        postService.update(id, postUpdateReqDto);
        return "redirect:/post/details/"+id ;
    }

    @GetMapping("/create")
    public String createPost(){

        return "post/post-create";
    }

   /* @PostMapping("/create")
    public String postSave(PostSaveReqDto postSaveReqDto) {
        postService.save(postSaveReqDto);
        return  "redirect:/post/list";
    }*/
    @PostMapping("/create")
    public String postSave(Model model, PostSaveReqDto postSaveReqDto/*, HttpServletRequest req*/, HttpSession httpSession) {
        try {
            //HttpServletRequest는 controller에서만, service 에서는 못 받음
            //세션 깂을 꺼내어 getAttribute("email")
//            HttpSession session=req.getSession();
//            System.out.println(session.getAttribute("email"));
            postService.save(postSaveReqDto,httpSession.getAttribute("email").toString());
            return "redirect:/post/list";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "post/post-create";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        postService.delete(id);
        return "ok";
    }

}
