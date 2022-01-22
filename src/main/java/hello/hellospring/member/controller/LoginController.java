package hello.hellospring.member.controller;

import hello.hellospring.member.domain.Member;
import hello.hellospring.member.domain.Sesson;
import hello.hellospring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * LoginController
 * @date 2022-01-11
 * @author miz-yi
 */
@Controller
public class LoginController {

    private final MemberService memberService;

    @Resource
    private Sesson sesson;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    /** 로그인 화면 */
    @GetMapping("/login/login")
    public String loginForm() {
        return "login/loginForm";
    }

    /** 로그인 */
    @PostMapping("/login/login")
    public String login(Member member) {
        memberService.login(member.getEmail(), member.getName());
        sesson.setEmail(member.getEmail());
        sesson.setName(member.getName());
        return "redirect:/";
    }

    /** 회원가입 화면 */
    @GetMapping("/login/join")
    public String joinForm() {
        return "login/joinForm";
    }

    /** 회원가입 등록 */
    @PostMapping("/login/join2")
//    @ResponseBody
    public String join(Member member) {
        memberService.join(member);
        return "redirect:/";
    }

    /** 비밀번호 찾기 화면 */
    @GetMapping("/login/passwrd")
    public String passwrdForm() {
        return "login/passwrdForm";
    }
}
