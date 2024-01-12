package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreById(Long id);
}
