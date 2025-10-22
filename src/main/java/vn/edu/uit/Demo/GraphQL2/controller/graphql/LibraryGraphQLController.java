package vn.edu.uit.Demo.GraphQL2.controller.graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import vn.edu.uit.Demo.GraphQL2.model.Author;
import vn.edu.uit.Demo.GraphQL2.model.Book;
import vn.edu.uit.Demo.GraphQL2.service.LibraryService;

@Controller
@AllArgsConstructor
public class LibraryGraphQLController {
    private final LibraryService libraryService;

    @QueryMapping
    public List<Book> books() {
        return libraryService.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument("bookId") Long bookId) {
        return libraryService.getBookById(bookId);
    }

    @QueryMapping
    public List<Author> authors() {
        return libraryService.getAllAuthors();
    }

    @MutationMapping
    public Author addAuthor(@Argument("name") String name) {
        return libraryService.addAuthor(name);
    }

    @MutationMapping
    public Book addBook(@Argument("title") String title, @Argument("authorId") Long authorId) {
        return libraryService.addBook(title, authorId);
    }
}
