package ru.kk.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kk.libraryproject.dto.AuthorDto;
import ru.kk.libraryproject.service.AuthorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/authors")
        //http://localhost:8080/authors
    String getAuthorsView(Model model) {
        List<AuthorDto> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }
}
