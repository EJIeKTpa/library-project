package ru.kk.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kk.libraryproject.dto.AuthorCreateDto;
import ru.kk.libraryproject.dto.AuthorDto;
import ru.kk.libraryproject.dto.AuthorUpdateDto;
import ru.kk.libraryproject.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping("/author/{id}") // http://localhost:8080/author/4
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }
    @GetMapping("/author/v1") //получить инфу об авторе по имени и списку книг через эндпоинт GET /author/v1?name=ИмяАвтора. http://localhost:8080/author/v1?name=Лев
    AuthorDto getAuthorByName(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName(name);
    }
    @GetMapping("/author/v2") //получить инфу об авторе по имени и списку книг через эндпоинт GET http://localhost:8080/author/v2?name=Лев
    AuthorDto getAuthorByName1(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName1(name);
    }
    @GetMapping("/author/v3") //получить инфу об авторе по имени и списку книг через эндпоинт GET http://localhost:8080/author/v3?name=Лев
    AuthorDto getAuthorByName2(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName2(name);
    }
    @PostMapping("/author/create") //http://localhost:8080/author/create
    AuthorDto createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
        return authorService.createAuthor(authorCreateDto);
    }
    @PutMapping("/author/update") //http://localhost:8080/author/update
    AuthorDto updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto){
        return authorService.updateAuthor(authorUpdateDto);
    }
    @DeleteMapping("/author/delete/{id}") //http://localhost:8080/author/delete/10
    void deleteAuthor(@PathVariable("id") Long id) {
    authorService.deleteAuthor(id);
    }
}