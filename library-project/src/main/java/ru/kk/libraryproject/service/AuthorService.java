package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getAuthorByName(String name);
    AuthorDto getAuthorByName1(String name);
    AuthorDto getAuthorByName2(String name);
}
