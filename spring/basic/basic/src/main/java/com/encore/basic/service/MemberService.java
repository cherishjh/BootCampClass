package com.encore.basic.service;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberRequestDto;
import com.encore.basic.domain.MemberResponseDto;
import com.encore.basic.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
  // 서비스에서 일반적으로 transcation 관리
//service annotation을 통해 싱글톤 컴포넌트로 생성 -> 스프링 빈으로 등록
//스프링 빈이란 스프링이 생성하고 관리하는 객체를 의미
//제어의 역전(Inversion of Control;IOC)-> IOC 컨테이너가 스프링빈을 관리(빈을 생성, 의존성 주입)
public class MemberService {
   /* @Autowired  //의존성 주입
    private MemoryMemberRepository memoryMemberRepository;*/
    //생성자 주입방식으로

    private final MemberRepository memberRepository;

    /*private final SpringDataJpaMemberRepository memberRepository;*/
//    @Autowired
//    public MemberService(MemoryMemberRepository memoryMemberRepository){
//        this.memberRepository=memoryMemberRepository;
//    }
//   @Autowired
//   public MemberService(JdbcMemberRepository jdbcMemberRepository){
//       this.memberRepository=jdbcMemberRepository;
//   }
    @Autowired  //springDataJpa  : 현대적
    public MemberService(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.memberRepository = springDataJpaMemberRepository;
    }
/*@Autowired
public MemberService(MybatisMemberRepository mybatisMemberRepository){
    this.memberRepository=mybatisMemberRepository;
}*/
   /* @Autowired
    public MemberService(JpaMemberRepository jpaMemberRepository){
        this.memberRepository=jpaMemberRepository;
    }*/



    /* public MemberService(){
         memoryMemberRepository= new MemoryMemberRepository();
     }*/
    public List<MemberResponseDto> members() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        for (Member member : members) {
            MemberResponseDto memberResponseDto = new MemberResponseDto();
            memberResponseDto.setId(member.getId());
            memberResponseDto.setName(member.getName());
            memberResponseDto.setEmail(member.getEmail());
            memberResponseDto.setPassword(member.getPassword());
            memberResponseDtos.add(memberResponseDto);
        }
        return memberResponseDtos;
    }

    //Transactional annotation 클래스 단위로 붙이면 모든 매서드에 각각 transaction 적용
//    transactional 적용하면 한 매서드 단위로 트랜잭션 지정
    @Transactional
    public void memberCreate(MemberRequestDto memberRequestDto) throws IllegalArgumentException{
        Member member = new Member(memberRequestDto.getName(), memberRequestDto.getEmail(), memberRequestDto.getPassword());
        memberRepository.save(member);
        /*  try {
            Member member = new Member(
                    memberRequestDto.getName(),
                    memberRequestDto.getEmail(),
                    memberRequestDto.getPassword());
            memberRepository.save(member);
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //transaction 테스트
      /*  Member member = new Member(memberRequestDto.getName(), memberRequestDto.getEmail(), memberRequestDto.getPassword());
        memberRepository.save(member);
        if(member.getName().equals("kim")){
            throw new IllegalArgumentException();
        }*/
    }



//    public MemberResponseDto findById(int id) throws NoSuchElementException {         //메모리 레포였을때
    public MemberResponseDto findById(int id) throws EntityNotFoundException {
//        Member member = memberRepository.findById(id).orElseThrow(NoSuchElementException::new);   메모리 레포였을때,
        Member member = memberRepository.findById(id).orElseThrow(()->new EntityNotFoundException("검색하신 ID의 회원 정보가 존재하지 않습니다."));
//        Member member= memberRepository.findById(id).orElseThrow(()->new NoSuchElementException("잘못된 요청입니다."));
        MemberResponseDto memberResponseDto= new MemberResponseDto();
        memberResponseDto.setId(member.getId());
        memberResponseDto.setName(member.getName());
        memberResponseDto.setEmail(member.getEmail());
        memberResponseDto.setPassword(member.getPassword());
        memberResponseDto.setCreate_time(member.getCreate_time());
        return memberResponseDto;
    }

    public void memberDelete(int id){
        Member member= memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        memberRepository.delete(member);
    }

    public void memberUpdate(MemberRequestDto memberRequestDto){
        Member member = memberRepository.findById(memberRequestDto.getId()).orElseThrow(EntityNotFoundException::new);
        member.setName(memberRequestDto.getName());
        member.setPassword(memberRequestDto.getPassword());
        memberRepository.save(member);
    }

}
