package hello.hellospring.member.repository;

import hello.hellospring.member.domain.Member;
import hello.hellospring.member.domain.MemberCharge;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
    Optional<Member> login(String email, String passwrd);

    MemberCharge saveCharge(MemberCharge memberCharge);
}