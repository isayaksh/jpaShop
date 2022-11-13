package jpabook.jpashop.controller.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "이메일은 필수 항목입니다.")
    private String email;

    @NotEmpty(message = "비밀번호은 필수 항목입니다.")
    private String password;

    @NotEmpty(message = "회원 이름은 필수 항목입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
