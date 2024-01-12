package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.dto.GenreDto;
import ru.kk.libraryproject.model.Genre;
import ru.kk.libraryproject.repository.GenreRepository;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        GenreDto genreDto = convertEntityToDto(genre);
        return genreDto;
    }
    private GenreDto convertEntityToDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks().stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build())
                .toList();

        GenreDto genreDto = GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookDtoList)
                .build();
        return genreDto;
    }
}
