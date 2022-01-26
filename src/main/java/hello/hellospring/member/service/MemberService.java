package hello.hellospring.member.service;

import hello.hellospring.member.domain.Member;
import hello.hellospring.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public void join(Member member) {
        // 같은 이메일, 이름의 중복 회원은 안된다.
        validateDuplicatateMember(member);
//        member.setRegdt(LocalDateTime.now());
        memberRepository.save(member);
    }

    private void validateDuplicatateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
   /* public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }*/

    /** 로그인 */
    public Boolean login(String email, String passwrd) {
        Optional<Member> member = memberRepository.login(email, passwrd);
        if (member.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
