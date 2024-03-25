package com.encore.classProject_ordering.member.service;


import com.encore.classProject_ordering.member.domain.Address;
import com.encore.classProject_ordering.member.domain.Member;
import com.encore.classProject_ordering.member.domain.Role;
import com.encore.classProject_ordering.member.dto.LoginReqDto;
import com.encore.classProject_ordering.member.dto.MemberCreateReqDto;
import com.encore.classProject_ordering.member.dto.MemberResponseDto;
import com.encore.classProject_ordering.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.print.DocFlavor;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Member create(MemberCreateReqDto memberCreateReqDto) throws IllegalArgumentException{
       /* Address address= new Address(memberCreateReqDto.getCity(),
                                     memberCreateReqDto.getStreet(),
                                     memberCreateReqDto.getZipcode());
        Member member= Member.builder()
                .name(memberCreateReqDto.getName())
                .email(memberCreateReqDto.getEmail())
                .password(passwordEncoder.encode(memberCreateReqDto.getPassword()))
                .address(address)
                .role(Role.USER)
                .build();*/
        // 이메일 중복 검사 필요
        if(memberRepository.findByEmail(memberCreateReqDto.getEmail()).isPresent()){
            throw new IllegalArgumentException("중복 이메일 입니다.");
        }

//        memberCreateReqDto.setPassword(passwordEncoder.encode(memberCreateReqDto.getPassword()));
        Member member= Member.toEntity(memberCreateReqDto);
        return memberRepository.save(member);
    }

    //회원 상세 정보 조회
    public MemberResponseDto findMyInfo(String email){
        Member member= memberRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        return MemberResponseDto.toMemberResponseDto(member);
    }


    public List<MemberResponseDto> findAll(){
        List<Member> members= memberRepository.findAll();
        return members.stream().map(m->MemberResponseDto.toMemberResponseDto(m)).collect(Collectors.toList());
    }




    public Member login(LoginReqDto loginReqDto) throws IllegalArgumentException {
//       email 존재 여부
        Member member= memberRepository.findByEmail(loginReqDto.getEmail())
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 이메일입니다."));
//       password 존재 여부
        if(!passwordEncoder.matches(loginReqDto.getPassword(), member.getPassword())){
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        }
        return member;
    }

    public MemberResponseDto findById(Long id) {
        Member member =  memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return MemberResponseDto.toMemberResponseDto(member);
    }

    public MemberResponseDto findByEmail(String email) {
        Member member =  memberRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        return MemberResponseDto.toMemberResponseDto(member);
    }


//    회원별 주문 목록 조회


}
