package vn.edu.uit.Demo.GraphQL2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.uit.Demo.GraphQL2.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
