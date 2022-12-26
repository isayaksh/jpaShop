package jpabook.jpashop.controller.member;

import jpabook.jpashop.controller.SessionConst;
import jpabook.jpashop.controller.login.LoginForm;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.cart.Cart;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.member.MemberDto;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){
        if(result.hasErrors()){
            return "members/createMemberForm";
        }
        Address address = Address.createAddress(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = Member.createMember(form.getEmail(), form.getPassword(), form.getUsername(),address, Cart.createCart());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(@PageableDefault(size = 8)Pageable pageable, Model model){
        pageable.getSort();
        Page<MemberDto> page = memberService.findAll(pageable);
        model.addAttribute("members", page);
        return "/members/memberList";
    }

    @GetMapping("/member/info")
    public String updateMemberForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId, Model model){
        Member findMember = memberService.findOne(memberId);
        MemberForm form = MemberForm.createMemberForm(findMember);
        model.addAttribute("memberForm", form);
        return "members/memberInfo";
    }

    @PostMapping("/member/edit")
    public String updateMember(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                               @Valid @ModelAttribute("memberForm")MemberForm form,
                               BindingResult bindingResult,
                               HttpServletRequest request){
        // MemberForm 에 email 혹은 password 의 값이 존재하지 않을 때
        if (bindingResult.hasErrors()) {
            return "/members/memberInfo";
        }

        memberService.updateMember(memberId, form.getEmail(), form.getPassword(), form.getUsername(), form.getCity(), form.getStreet(), form.getZipcode(), request);
        return "redirect:/member/info";
    }
}
