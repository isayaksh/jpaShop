package jpabook.jpashop.service;

import jpabook.jpashop.controller.login.LoginForm;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.exception.NotCorrespondingEmailException;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = Member.createMember(null,null,"memberA",null);

        // when
        Long memberId = memberService.join(member);

        // then
        em.flush();
        assertEquals(member, memberService.findOne(memberId));
    }
    
    @Test()
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = Member.createMember(null,null,"memberA",null);
        Member member2 = Member.createMember(null,null,"memberA",null);

        // when
        memberService.join(member1);
        try{
            memberService.join(member2);
        } catch (IllegalStateException e){
            return;
        }
        // then
        fail("예외가 발생해야 한다.");
    }

//    @Test
//    public void 로그인() throws Exception {
//        // given
//        Member member = Member.createMember("ID","PASSWORD","memberA",null);
//        Long memberId = memberService.join(member);
//        // when
//        LoginForm form = new LoginForm(member.getEmail(), member.getPassword());
//        memberService.login(form);
//        // then
//    }
//
//    @Test
//    public void 로그인_아이디_오류() throws Exception {
//        // given
//        Member member = Member.createMember("ID","PASSWORD","memberA",null);
//        Long memberId = memberService.join(member);
//        LoginForm form = new LoginForm("NOID", member.getPassword());
//        // when
//        try{
//            memberService.login(form);
//        } catch (NotCorrespondingEmailException e){
//            return;
//        }
//        // then
//        fail("예외가 발생해야 한다.");
//    }
//
//    @Test
//    public void 로그인_비밀번호_오류() throws Exception {
//        // given
//        Member member = Member.createMember("ID","PASSWORD","memberA",null);
//        Long memberId = memberService.join(member);
//        LoginForm form = new LoginForm(member.getEmail(), "NOPASSWORD");
//        // when
//        try{
//            memberService.login(form);
//        } catch (IllegalStateException e){
//            return;
//        }
//        // then
//        fail("예외가 발생해야 한다.");
//    }
}