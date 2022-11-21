package jpabook.jpashop.repository.member;

import jpabook.jpashop.domain.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsername(String name);
    Optional<Member> findByEmail(String email);

    Page<Member> findAll(Pageable pageable);
}
