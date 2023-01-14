package jpabook.jpashop.controller.login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {
    @NotEmpty(message = "이메일은 필수 항목입니다.")
    private String email;
    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String password;
}
