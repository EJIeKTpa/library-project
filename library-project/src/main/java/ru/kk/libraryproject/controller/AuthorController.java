package ru.kk.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kk.libraryproject.dto.AuthorDto;
import ru.kk.libraryproject.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping("/author/{id}") // http://localhost:8080/author/4
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }
    @GetMapping("/author/v1") //получить инфу об авторе по имени и списку книг через эндпоинт GET /author/v1?name=ИмяАвтора.
    AuthorDto getAuthorByName(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName(name);
    }
    @GetMapping("/author/v2") //получить инфу об авторе по имени и списку книг через эндпоинт GET /author/v2?name=ИмяАвтора.
    AuthorDto getAuthorByName1(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName1(name);
    }
    @GetMapping("/author/v3") //получить инфу об авторе по имени и списку книг через эндпоинт GET /author/v3?name=ИмяАвтора.
    AuthorDto getAuthorByName2(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName2(name);
    }
}