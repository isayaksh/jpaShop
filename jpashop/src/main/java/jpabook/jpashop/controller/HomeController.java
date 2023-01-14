package jpabook.jpashop.controller;

import jpabook.jpashop.controller.login.LoginForm;
import jpabook.jpashop.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @GetMapping
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId, Model model){

        /** 로그인 페이지로 이동 **/
        if(memberId == null) {
            model.addAttribute("loginForm", new LoginForm());
            return "logins/loginForm";
        }

        /** 메인 페이지로 이동 **/
        return "home";
    }
}
