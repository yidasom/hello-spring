package hello.hellospring.member.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import hello.hellospring.member.domain.Member;
import hello.hellospring.member.domain.MemberInfo;
import hello.hellospring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * LoginController
 * @date 2022-01-11
 * @author miz-yi
 */
@Controller
public class LoginController {

    private final MemberService memberService;

    @Resource
    private MemberInfo info;

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
    @PostMapping(value = "/login/loginJson", produces = "application/json; charset=utf8;")
    @ResponseBody
    public Optional<Member> login(@RequestBody Member member, HttpServletResponse response) {
        Gson gson = new Gson();
        Optional<Member> mem = memberService.login(member.getEmail(), member.getPasswrd());
//        String obj = gson.toJson(mem);
        String obj = "";

        if (!mem.equals(null)) {
            // 세션 넣기
            info.setEmail(member.getEmail());
            info.setName(member.getName());
            if (Boolean.valueOf(member.getRemEmail())) {
                // 쿠키 넣기
                Cookie cookie = new Cookie("userEmail", member.getEmail());
                response.addCookie(cookie);
            }
        }
        return mem;
    }

    // 세션 불러옴
    @GetMapping("/login/session")
    @ResponseBody
    public String get() {
        return info.getEmail();
    }

    /** 회원가입 화면 */
    @GetMapping("/login/join")
    public String joinForm() {
        return "login/joinForm";
    }

    /** 회원가입 등록 */
    @PostMapping("/login/join2")
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
