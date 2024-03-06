package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.AuthorCreateDto;
import ru.kk.libraryproject.dto.AuthorDto;
import ru.kk.libraryproject.dto.AuthorUpdateDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getAuthorByName(String name);
    AuthorDto getAuthorByName1(String name);
    AuthorDto getAuthorByName2(String name);
    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
    AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto);
    void deleteAuthor(Long Id);
}
