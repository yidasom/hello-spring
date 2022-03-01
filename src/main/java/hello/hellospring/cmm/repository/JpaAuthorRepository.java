package hello.hellospring.cmm.repository;

import hello.hellospring.cmm.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * hello.hellospring.cmm.repository
 *
 * @author : idasom
 * @data : 2022/03/01
 */
public class JpaAuthorRepository implements AuthorRepository {

    @PersistenceContext
    private final EntityManager em;

    public JpaAuthorRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Author insertAuthorById(Author author) {
        em.persist(author);
        return author;
    }
}
