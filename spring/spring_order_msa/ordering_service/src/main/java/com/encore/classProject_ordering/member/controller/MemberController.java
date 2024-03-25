package com.encore.classProject_ordering.member.controller;


import com.encore.classProject_ordering.common.CommonResponse;
import com.encore.classProject_ordering.member.dto.MemberResponseDto;
import com.encore.classProject_ordering.order.dto.OrderResDto;
import com.encore.classProject_ordering.order.service.OrderService;
import com.encore.classProject_ordering.security.JwtTokenProvider;
import com.encore.classProject_ordering.member.domain.Member;
import com.encore.classProject_ordering.member.dto.LoginReqDto;
import com.encore.classProject_ordering.member.dto.MemberCreateReqDto;
import com.encore.classProject_ordering.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MemberController {
    private final MemberService memberService;
    private final OrderService orderService;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberController(MemberService memberService, OrderService orderService, JwtTokenProvider jwtTokenProvider) {
        this.memberService = memberService;
        this.orderService = orderService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //회원 가입
    @PostMapping("/member/new")
    public ResponseEntity<CommonResponse> memberCreate(@Valid @RequestBody MemberCreateReqDto memberCreateReqDto){
        Member member= memberService.create(memberCreateReqDto);
        return new ResponseEntity<>(new CommonResponse(
                                        HttpStatus.CREATED,"member successfully created",member.getId()),
                                        HttpStatus.CREATED);
    }

    //회원 목록
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/members")
    public List<MemberResponseDto> members(){
       return memberService.findAll();
    }


    //내 정보 조회
    @GetMapping("/member/myInfo")
    public MemberResponseDto findMyInfo(){
        return memberService.findMyInfo();
    }

    //관리자가 회원별 주문을 볼때
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/member/{id}/orders")
    public List<OrderResDto> getOrderList(@PathVariable Long id){
        return orderService.findByMember(id);
    }


    // 회원이 자신의 주문을 볼때 -> authentication 객체에서 꺼내옴
//    @PreAuthorize("hasRole('ADMIN') or #email ==  authentication.principal.username")           //여기서 추가로 admin 붙이는게 의미 없어보이지만 일단 넣는 방향으로
    @GetMapping("/member/myorders")
    public List<OrderResDto> findMyOrders(){
        return orderService.findMyOrders();
    }


    //마이페이지
    @GetMapping("/mypage")
    public String myPage( ){
        MemberResponseDto memberResponseDto = memberService.findMyInfo();

        List<OrderResDto> orderResDto = orderService.findMyOrders();
        return "ok";
    }


    //로그인
    @PostMapping("/doLogin")
//    public ResponseEntity<Map<String,Object>> memberLogin(@Valid @RequestBody LoginReqDto loginReqDto){
    public ResponseEntity<CommonResponse> memberLogin(@Valid @RequestBody LoginReqDto loginReqDto){
        Member member= memberService.login(loginReqDto);
//        토큰 생성
        String jwtToken= jwtTokenProvider.createToken(member.getEmail(),member.getRole().toString());
        Map<String, Object> member_info= new HashMap<>();
        member_info.put("id",member.getId());
        member_info.put("token",jwtToken);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK, "member successfully logged in",member_info), HttpStatus.OK);
    }





}
