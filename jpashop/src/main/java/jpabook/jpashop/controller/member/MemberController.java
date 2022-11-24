package jpabook.jpashop.controller.member;

import jpabook.jpashop.domain.Address;
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
        Member member = Member.createMember(form.getEmail(), form.getPassword(), form.getName(),address);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(@PageableDefault(size = 8)Pageable pageable, Model model){
        Page<MemberDto> page = memberService.findAll(pageable);
        model.addAttribute("members", page);
        return "/members/memberList";
    }

}
