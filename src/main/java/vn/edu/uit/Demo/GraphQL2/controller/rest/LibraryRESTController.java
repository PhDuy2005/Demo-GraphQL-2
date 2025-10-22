package vn.edu.uit.Demo.GraphQL2.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import vn.edu.uit.Demo.GraphQL2.model.Author;
import vn.edu.uit.Demo.GraphQL2.model.Book;
import vn.edu.uit.Demo.GraphQL2.model.dto.book_dto.dtoReqBook;
import vn.edu.uit.Demo.GraphQL2.service.LibraryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class LibraryRESTController {
    private final LibraryService libraryService;

    @GetMapping("/hello")
    public ResponseEntity<?> getMethodName() {
        return ResponseEntity.status(HttpStatus.OK).body(new Author());
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {
        List<Book> books = libraryService.getAllBooks();
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllBooks());
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody dtoReqBook dto) {
        // TODO: process POST request
        Book entity = libraryService.addBook(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

}
