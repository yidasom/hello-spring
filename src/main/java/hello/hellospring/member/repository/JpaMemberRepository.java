package hello.hellospring.member.repository;

import hello.hellospring.member.domain.Member;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from y_member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        List<Member> result = em.createQuery("select m from y_member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from y_member m", Member.class).getResultList();
    }

    /** 로그인 */
    @Override
    public Optional<Member> login(String email, String passwrd) {
        Optional<Member> result = em.createQuery("select m from y_member m where m.email = :email and m.passwrd = :passwrd", Member.class)
                .setParameter("email", email)
                .setParameter("passwrd", passwrd)
                .getResultList().stream().findAny();
         return result;
    }
}
