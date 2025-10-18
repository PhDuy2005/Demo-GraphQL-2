package vn.edu.uit.Demo.GraphQL2.controller.rest;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.edu.uit.Demo.GraphQL2.service.LibraryService;

@RestController
@AllArgsConstructor
public class LibraryRESTController {
    private final LibraryService libraryService;
}
