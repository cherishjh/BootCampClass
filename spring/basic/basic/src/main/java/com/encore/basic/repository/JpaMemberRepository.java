package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository{
    // EntityManager는 JPA 핵심 클래스 (객체)
    // Entity의 생명 주기 관리; 데이터베이스와의 모든 상호작용을 책임.
    // entity를 대상하고 CRUD(create, read, update, delete) 하는 기능을 제공한다.
    private final EntityManager entityManager;

    //생성자가 하나임으로 @autowired 생략 가능
    public JpaMemberRepository (EntityManager entityManager){
        this.entityManager= entityManager;
    }

    @Override
    public Member save(Member member) {
//        persist: 전달된 entity(여기선 member)가 JPA의 EntityManager의 관리 상태가 되도록 만들어주고,
//                  트렌젝션이 commit될때  데이터베이스에 저장, insert 포함
        entityManager.persist(member);
        return null;
    }

    @Override
    public Optional<Member> findById(int id) {
//        find 메서드는 한 건을 찾는 메서드이기 때문에 pk를 매개변수로 준다.
        Member member = entityManager.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public void delete(Member member) {
//      delete 의 경우 remove 매서드 사용
//      update 의 경우 merge 매서드 사용
    }


//    pk 외의 컬럼으로 조회할 때
/*    public List<Member> findByName(String name){
        List<Member> members= entityManager
                                .createQuery("select m from Member m where m.name= :name",Member.class)
                                .setParameter("name", name).getResultList();
        return members;
    }*/

    @Override
    public List<Member> findAll() {            //?
        // jpql: jpa의 객체 지향 쿼리 문법
        // 장점: DB에 따라 문법이 달라지지 않는 객체지향언어; complie타임에서 체크해준다.(raw커리의 가장 큰 문제점); Spring data Jpa의 기능
        // 단점: DB 고유의 기능과 성능을 극대화하기는 어려움
        List<Member> members= entityManager.createQuery("select m from Member m", Member.class).getResultList();   //select * from Member m에서 alias 문법을 사용해서 * 말고 m을 넣어줌
        return members;
    }
}
