package hello.hellospring.cmm.service;

import hello.hellospring.cmm.domain.Author;
import hello.hellospring.cmm.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * hello.hellospring.cmm.service
 *
 * @author : idasom
 * @data : 2022/03/01
 */
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /** 권한 조회 및 부여 */
    public void validateAuthor(Author author) {
        author.setAuthor("ROLE_USER");
        authorRepository.insertAuthorById(author.getMember().getId());
    }
}
