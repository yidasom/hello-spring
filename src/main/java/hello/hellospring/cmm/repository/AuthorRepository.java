package hello.hellospring.cmm.repository;

import hello.hellospring.cmm.domain.Author;

import java.util.Optional;

/**
 * hello.hellospring.cmm.repository
 *
 * @author : idasom
 * @data : 2022/03/01
 */
public interface AuthorRepository {
    Author insertAuthorById(Author author);
}
