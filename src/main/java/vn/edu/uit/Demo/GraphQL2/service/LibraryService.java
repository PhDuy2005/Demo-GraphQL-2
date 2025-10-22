package vn.edu.uit.Demo.GraphQL2.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vn.edu.uit.Demo.GraphQL2.model.Author;
import vn.edu.uit.Demo.GraphQL2.model.Book;
import vn.edu.uit.Demo.GraphQL2.model.dto.book_dto.dtoReqBook;
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
        Book book = new Book();
        try {
            Author author = authorRepository.findById(authorId).get();
            if (author == null) {
                throw new NoSuchElementException("Author with ID " + authorId + " not found.");
            }
            book.setTitle(title);
            book.setAuthor(author);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Author with ID " + authorId + " not found.");
        }
        return bookRepository.save(book);
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public Book addBook(dtoReqBook dto) {
        Book book = new Book();
        try {
            Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow();

            book.setTitle(dto.getTitle());
            book.setAuthor(author);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Author with ID " + dto.getAuthorId() + " not found.");
        }
        return bookRepository.save(book);
    }

    public Author addAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }
}
