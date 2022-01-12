package hello.hellospring.member.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * LoginController
 * @date 2022-01-11
 * @author miz-yi
 */
@Controller
public class LoginController {

    private final MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }


    /** 로그인 화면 */
    @GetMapping("/login/login")
    public String loginForm() {
        return "login/loginForm";
    }

    /** 회원가입 화면 */
    @GetMapping("/login/join")
    public String joinForm() {
        return "login/joinForm";
    }

    /** 회원가입 등록 */
    @PostMapping("/login/join")
    @ResponseBody
    public Boolean join(Member member) {
        memberService.join(member);
        return true;
    }

    /** 비밀번호 찾기 화면 */
    @GetMapping("/login/passwrd")
    public String passwrdForm() {
        return "login/passwrdForm";
    }
}
