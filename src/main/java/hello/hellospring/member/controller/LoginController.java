package hello.hellospring.member.controller;

import com.google.gson.Gson;
import hello.hellospring.cmm.domain.Author;
import hello.hellospring.cmm.service.AuthorService;
import hello.hellospring.member.domain.Member;
import hello.hellospring.member.domain.MemberInfo;
import hello.hellospring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * LoginController
 * @date 2022-01-11
 * @author miz-yi
 */
@Controller
public class LoginController {

    private final MemberService memberService;
    private final AuthorService authorService;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from_email;

    @Resource
    private MemberInfo info;
    private String string;

    @Autowired
    public LoginController(MemberService memberService, AuthorService authorService, JavaMailSender javaMailSender) {
        this.memberService = memberService;
        this.authorService = authorService;
        this.javaMailSender = javaMailSender;
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
        Optional<Member> loginMember = memberService.login(member.getEmail(), member.getPasswrd());
//        String obj = gson.toJson(mem);
        Optional<Member> findMember = memberService.findEmail(member.getEmail());

        if (!loginMember.equals(null)) {
            // 세션 넣기
            info.setEmail(findMember.get().getEmail());
            info.setName(findMember.get().getName());
            info.setId(findMember.get().getId());
            if (Boolean.valueOf(member.getRemEmail())) {
                // 쿠키 넣기
                Cookie cookie = new Cookie("userEmail", member.getEmail());
                response.addCookie(cookie);
            }
        }
        return loginMember;
    }

    // 세션 불러옴
    @GetMapping("/login/index")
    public String loginIndex(Model model, HttpSession session) {
        return "index";
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
        /** 권한 등록 */
        Author author = new Author();
        author.setMember(member);
        authorService.validateAuthor(author);
        return "redirect:/";
    }

    /** 비밀번호 찾기 화면 */
    @GetMapping("/login/passwrd")
    public String passwrdForm() {
        return string;
    }

    /** 이메일 보내기 */
    @PostMapping(value = "/login/passwrdJson", produces = "application/json; charset=utf8;")
    @ResponseBody
    public Optional<Member> sendMail(@RequestBody Member member) throws MessagingException {
        Gson gson = new Gson();
        Optional<Member> result = memberService.findEmail(member.getEmail());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(result.get().getEmail());
        message.setFrom(from_email);
        message.setSubject("본인 인증하십니까?");
        message.setText("1234");

        javaMailSender.send(message);

        return result;
    }
}
