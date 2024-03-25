package com.encore.basic.Controller;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberRequestDto;
import com.encore.basic.domain.MemberResponseDto;
import com.encore.basic.service.MemberService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@Api(tags="회원관리서비스")
@Controller
//restAPI 사용할때 사용
@RestController
@RequestMapping("/rest")
public class MemberRestController {
    private final MemberService memberService;
    @Autowired
    public MemberRestController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/member/create")
    public String MemberAdd(@RequestBody MemberRequestDto memberRequestDto) {
        memberService.memberCreate(memberRequestDto);
        return "ok";
    }

    @GetMapping("/members")
    public List<MemberResponseDto> getMembers() {
        return memberService.members();
    }


    @GetMapping("/member/find/{id}")
    public ResponseEntity<Map<String,Object>> getMemberDetail(@PathVariable int id){
        MemberResponseDto memberResponseDto=null;
        try{
            memberResponseDto= memberService.findById(id);
            return ResponseEntityController.responseMessage(HttpStatus.OK,memberResponseDto);
        } catch (EntityNotFoundException e){
            e.printStackTrace();
            return ResponseEntityController.errResponseMessage(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PatchMapping("/member/update")
    public MemberResponseDto MemberUpdate(@RequestBody MemberRequestDto memberRequestDto){
        memberService.memberUpdate(memberRequestDto);
        return memberService.findById(memberRequestDto.getId());
    }

    @DeleteMapping("/member/delete/{id}")
    public String getMemberDelete(@PathVariable int id){
        memberService.memberDelete(id);
        return "ok";
    }
}
