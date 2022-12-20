package jpabook.jpashop.service;

import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingEmailException;
import jpabook.jpashop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true) // 모든 통신활동 설정을 readOnly = true로 설정한다.
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Long login(String email, String password) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if(!findMember.orElseThrow(()->new NotCorrespondingEmailException("해당 이메일이 존재하지 않습니다.")).checkPassword(password)){
            throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
        }
        return findMember.get().getId();
    }

}
