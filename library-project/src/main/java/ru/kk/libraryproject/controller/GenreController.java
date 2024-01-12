package ru.kk.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.kk.libraryproject.dto.GenreDto;
import ru.kk.libraryproject.service.GenreService;

@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;
    @GetMapping("/genre/{id}")
    GenreDto getGenreById(@PathVariable("id") Long id) {
        return genreService.getGenreById(id);
    }
}
