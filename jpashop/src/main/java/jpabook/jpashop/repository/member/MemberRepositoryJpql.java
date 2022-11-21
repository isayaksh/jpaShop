package jpabook.jpashop.repository.member;

import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.repository.OrderSearch;

import java.util.List;

public interface MemberRepositoryJpql {

    List<Member> findAll(OrderSearch orderSearch);

}
