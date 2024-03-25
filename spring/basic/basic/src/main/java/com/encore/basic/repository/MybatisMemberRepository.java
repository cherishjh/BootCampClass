package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//mybatis 레파짓토리로
@Repository
@Mapper
public interface MybatisMemberRepository extends MemberRepository{
//  본문에 MybatisRepository에서 사용할 메서드 명세를 정의해야 한다.
//  MemberRepository에서 상속 받고 있으므로 생략 가능
//    실질적인 쿼리 등 구현은 resources/mapper/MemberMapper.xml파일에 수행
/*public List<Member> findAll();
    public Member save(Member member);
    public Optional<Member> findById(int id);*/   //생략 가능
}
