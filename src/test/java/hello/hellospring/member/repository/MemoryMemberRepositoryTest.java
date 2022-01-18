package hello.hellospring.member.repository;

import hello.hellospring.member.domain.Member;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save() {

    }

    @Test
    public void login() {
        Member member = new Member();

        member.setEmail("111");
        member.setPasswrd("111222");
        memoryMemberRepository.save(member);

        Member res = memoryMemberRepository.login("111", "111222").get();


        Assertions.assertThat(res).isEqualTo(member);
    }
}
