/*
package hello.hellospring.member.repository;

import hello.hellospring.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPA select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);

    @Override
    Optional<Member> login(String email, String passwrd);
}*/
