package vn.edu.uit.Demo.GraphQL2.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import vn.edu.uit.Demo.GraphQL2.model.Author;
import vn.edu.uit.Demo.GraphQL2.model.Book;
import vn.edu.uit.Demo.GraphQL2.service.LibraryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
public class LibraryRESTController {
    private final LibraryService libraryService;

    @GetMapping("/hello")
    public ResponseEntity<?> getMethodName() {
        return ResponseEntity.status(HttpStatus.OK).body(new Author());
    }

}
