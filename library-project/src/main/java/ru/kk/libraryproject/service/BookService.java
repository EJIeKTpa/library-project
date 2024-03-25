package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.BookCreateDto;
import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.dto.BookUpdateDto;

import java.util.List;

public interface BookService {

    BookDto getBookById(Long id);
    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);
    BookDto createBook(BookCreateDto bookCreateDto);
    BookDto updateBook(BookUpdateDto bookUpdateDto);
    void deleteBook(Long Id);
    List<BookDto> getAllBooks();
}
