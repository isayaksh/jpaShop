package jpabook.jpashop.service;

import jpabook.jpashop.controller.login.LoginForm;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.exception.NotCorrespondingEmailException;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) // 모든 통신활동 설정을 readOnly = true로 설정한다.
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional // DB에 데이터를 변경하는 경우 추가해준다.
    public Long join(Member member){
        validateDuplicateMember(member.getEmail()); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 회원 전체 조회
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findById(memberId).get();
    }

    private void validateDuplicateMember(String email) {
        //EXCEPTION
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if(findMember.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).get();
        validateDuplicateMember(name);
        member.changeName(name);
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

    public Page<Member> findByPage(int offset, int size){
        return memberRepository.findAll(PageRequest.of(offset, size));
    }


    // 회원 페이징 조회
}
