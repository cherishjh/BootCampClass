package com.encore.basic.repository;

import com.encore.basic.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public List<Member> findAll();
    public Member save(Member member);
    public Optional<Member> findById(int id);
    public void delete(Member member);
}
