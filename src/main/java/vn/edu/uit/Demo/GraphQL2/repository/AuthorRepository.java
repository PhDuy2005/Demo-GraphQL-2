package vn.edu.uit.Demo.GraphQL2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.uit.Demo.GraphQL2.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
