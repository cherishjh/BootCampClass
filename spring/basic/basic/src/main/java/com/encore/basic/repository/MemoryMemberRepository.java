package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import com.encore.basic.service.MemberService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//database로 연결

@Repository      //
public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> memberDB;

    static int total_id;

    public MemoryMemberRepository() {
        memberDB = new ArrayList<>();
    }


    @Override
    public List<Member> findAll() {
        return memberDB;
    }


    @Override
    public Member save(Member member) {
        total_id+=1;
        LocalDateTime now= LocalDateTime.now();
        member.setId(total_id);
        member.setCreate_time(now);
        memberDB.add(member);
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {
        for (Member m : memberDB) {
            if (m.getId() == id) {
                return Optional.of(m);
            }
        }
        return null;  //이게 있어서 ofNullable 사용하지 않아도 됨.

    }

    @Override
    public void delete(Member member) {

    }


}
