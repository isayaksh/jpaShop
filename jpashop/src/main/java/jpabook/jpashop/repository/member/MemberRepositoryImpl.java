package jpabook.jpashop.repository.member;

import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryJpql{

    private final EntityManager em;

    @Override
    public List<Member> findAll(OrderSearch orderSearch) {
        return null;
    }
}
