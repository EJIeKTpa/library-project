package ru.kk.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kk.libraryproject.dto.*;
import ru.kk.libraryproject.service.BookService;


@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/book/{id}") // http://localhost:8080/book/4
    BookDto getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/book/v1") //http://localhost:8080/book/v1?name=Война%20и%20мир
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
    @PostMapping("book/create") //http://localhost:8080/book/create
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }
    @PutMapping("/book/update") //http://localhost:8080/book/update
    BookDto updateBook(@RequestBody BookUpdateDto bookUpdateDto){
        return bookService.updateBook(bookUpdateDto);
    }
}