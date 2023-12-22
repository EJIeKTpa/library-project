package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
}
