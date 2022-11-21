package jpabook.jpashop.controller.member;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.PageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
        Member member = Member.createMember(form.getEmail(), form.getPassword(), form.getName(),address);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        model.addAttribute("members", memberService.findAll());
        return "/members/memberList";
    }

}
