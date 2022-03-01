package hello.hellospring;

import hello.hellospring.cmm.repository.AuthorRepository;
import hello.hellospring.cmm.repository.JpaAuthorRepository;
import hello.hellospring.cmm.service.AuthorService;
import hello.hellospring.member.repository.*;
import hello.hellospring.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public AuthorService authorService() {
        return new AuthorService(authorRepository());
    }

    @Bean
    public AuthorRepository authorRepository() {
        return new JpaAuthorRepository(em);
    }
}
