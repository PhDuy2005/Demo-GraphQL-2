package vn.edu.uit.Demo.GraphQL2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vn.edu.uit.Demo.GraphQL2.model.Author;
import vn.edu.uit.Demo.GraphQL2.model.Book;
import vn.edu.uit.Demo.GraphQL2.repository.AuthorRepository;
import vn.edu.uit.Demo.GraphQL2.repository.BookRepository;

@Service
@AllArgsConstructor
public class LibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Book addBook(String title, Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Author addAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }
}
