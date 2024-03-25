package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//spring data jpa의 기본 기능을 쓰기 위해서는 JpaRepository를 상속해야 함
//상속시에 entity명과 해당 entity의 pk 타입을 명시
//실질적인 구현클래스와 스펙은 SimpleJpaRepository 클래스에 있고,
//실질적인 구동 상황에서 hibernate 구현체에 동작 위임.

public interface SpringDataJpaMemberRepository extends MemberRepository, JpaRepository<Member, Integer> {

}
