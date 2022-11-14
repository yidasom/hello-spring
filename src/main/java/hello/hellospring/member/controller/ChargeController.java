package hello.hellospring.member.controller;

import hello.hellospring.member.domain.Member;
import hello.hellospring.member.domain.MemberCharge;
import hello.hellospring.member.domain.MemberInfo;
import hello.hellospring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 회원 요금 상세 Controll
 * @author : idasom
 * @data : 2022/03/08
 */
@Controller
public class ChargeController {

    private final MemberService memberService;

    @Resource
    private MemberInfo info;

    @Autowired
    public ChargeController(MemberService memberService) {
        this.memberService = memberService;
    }

    /** 회원 요금 등록 */
    @PostMapping("/charge/save")
    public String saveCharge(MemberCharge memberCharge, Model model) {
        Member member = new Member();
        member.setId(info.getId());
        memberCharge.setMember(member);
        memberService.saveCharge(memberCharge);
        model.addAttribute("memberCharge", memberCharge);
        return "index";
    }
}
