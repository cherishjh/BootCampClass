package com.encore.basic.Controller;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberRequestDto;
import com.encore.basic.domain.MemberResponseDto;
import com.encore.basic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@Controller
public class MemberController {
    //의존성 주입 방법 1: 필드 주입 방식
   /* @Autowired
    private MemberService memberService;*/

    //의존성 주입 방법 2: 생성자 주입 방식(많이 사용)
    //장점: final을 통해 상수로 사용 가능, 다형성 구현 가능, 순환참조 방지
    //생성자가 하나 일때는 autowired 생략 가능
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //의존성 주입 방법 3: @RequiredArgsConstructor 이용한 방식
    //@RequiredArgsConstructor :
    //@NonNull annotation이 붙어 있는 필드 또는 초기화 되지 않은 final 필드를 대상으로 생성자 생성
//    private final MemberService memberService;

  /*  MemberController(){
        memberService = new MemberService();
    }*/

    @GetMapping("member/create")
    public String memberCreateScreen() {
        return "member/member-create-screen";
    }

    @PostMapping("member/create")
//    @ResponseBody
    public String save(MemberRequestDto memberRequestDto) {
        //트랜잭션 및 예외처리 테스트
        /*    try{
            memberService.memberCreate(memberRequestDto);
        } catch(IllegalArgumentException e){   //controller에서
            return "/member/404-error-page";
        }*/

        /*System.out.println(memberRequestDto.getName());
        System.out.println(memberRequestDto.getEmail());
        System.out.println(memberRequestDto.getPassword());*/
        memberService.memberCreate(memberRequestDto);
        //url redirect
        return "redirect:/members";
    }


    @GetMapping("members")
    public String findAll(Model model) {
        model.addAttribute("memberList", memberService.members());
        return "member/memberList";
    }

    @GetMapping("/")
    public String home() {
        return "member/header";
    }


    @GetMapping("/member/find")
    public String details(@RequestParam(value = "id") int id, Model model) {

        try {
            MemberResponseDto memberResponseDto = memberService.findById(id);
            System.out.println(memberResponseDto);
            model.addAttribute("member", memberResponseDto);
            return "member/memberDetail";
//        } catch (NoSuchElementException e) {         //메모리 레포 였을때
        } catch (EntityNotFoundException e) {           //엔디티(DB)
            return "member/404-error-page";
        }
    }

    @GetMapping("/member/delete")
    public String delete(@RequestParam (value= "id") int id){
            memberService.memberDelete(id);
            return "redirect:/members";
    }

    @PostMapping("/member/update")
    public String memberUpdate(MemberRequestDto memberRequestDto){
        memberService.memberUpdate(memberRequestDto);
        return "redirect:/member/find?id="+memberRequestDto.getId();
    }

}
