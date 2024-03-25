//package com.encore.basic.service;
//
//import com.encore.basic.domain.Member;
//import com.encore.basic.domain.MemberRequestDto;
//import com.encore.basic.domain.MemberResponseDto;
//import com.encore.basic.repository.MemberRepository;
//import com.encore.basic.repository.MemoryMemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
////service annotation을 통해 싱글톤 컴포넌트로 생성 -> 스프링 빈으로 등록
////스프링 빈이란 스프링이 생성하고 관리하는 객체를 의미
////제어의 역전(Inversion of Control;IOC)-> IOC 컨테이너가 스프링빈을 관리(빈을 생성, 의존성 주입)
//public class MemberService1 {
//   /* @Autowired  //의존성 주입
//    private MemoryMemberRepository memoryMemberRepository;*/
//    //생성자 주입방식으로
//
//    private final MemberRepository memberRepository;
//    @Autowired
//    public MemberService1(MemoryMemberRepository memoryMemberRepository){
//        this.memberRepository=memoryMemberRepository;
//    }
//
//    private int total_id;
//   /* public MemberService(){
//        memoryMemberRepository= new MemoryMemberRepository();
//    }*/
//    public List<MemberResponseDto> members(){
//        List<Member> members= memberRepository.findAll();
//        List<MemberResponseDto> memberResponseDtos= new ArrayList<>();
//        for(Member member: members){
//            MemberResponseDto memberResponseDto= new MemberResponseDto();
//            memberResponseDto.setId(member.getId());
//            memberResponseDto.setName(member.getName());
//            memberResponseDto.setEmail(member.getEmail());
//            memberResponseDto.setPassword(member.getPassword());
//            memberResponseDtos.add(memberResponseDto);
//        }
//        return memberResponseDtos;
//    }
//
//    public Member memberCreate(MemberRequestDto memberRequestDto){
//        LocalDateTime now= LocalDateTime.now();
//        Member member= new Member(total_id,
//                memberRequestDto.getName(),
//                memberRequestDto.getEmail(),
//                memberRequestDto.getPassword(),
//                now);
//        memberRepository.save(member);
//        return member;
//    }
//
//
//    public MemberResponseDto findById(int id) throws NoSuchElementException {
//        Member member= memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
////        Member member= memberRepository.findById(id).orElseThrow(()->new NoSuchElementException("잘못된 요청입니다."));
//        MemberResponseDto memberResponseDto= new MemberResponseDto();
//        memberResponseDto.setId(member.getId());
//        memberResponseDto.setName(member.getName());
//        memberResponseDto.setEmail(member.getEmail());
//        memberResponseDto.setPassword(member.getPassword());
//        memberResponseDto.setCreate_time(member.getCreate_time());
//        return memberResponseDto;
//    }
//
//}
