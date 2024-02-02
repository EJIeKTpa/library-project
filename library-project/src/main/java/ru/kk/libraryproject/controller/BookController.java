package ru.kk.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/book") //http://localhost:8080/book/?name=Война%20и%20мир
    BookDto getBookByNameV1(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV1(name);
    }
    @GetMapping("/book/v2") //http://localhost:8080/book/v2?name=Война%20и%20мир
    BookDto getBookByNameV2(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV2(name);
    }
    @GetMapping("/book/v3") //http://localhost:8080/book/v3?name=Война%20и%20мир
    BookDto getBookByNameV3(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV3(name);
    }


}
