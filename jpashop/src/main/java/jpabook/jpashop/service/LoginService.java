package jpabook.jpashop.service;

import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingEmailException;
import jpabook.jpashop.exception.NotCorrespondingException;
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
        Member findMember = memberRepository.findByEmail(email).orElseThrow( ()-> new NotCorrespondingEmailException("LoginService : login → email과 password가 일치하지 않습니다."));

        if(!findMember.checkPassword(password)){
            throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
        }

        return findMember.getId();
    }

}
