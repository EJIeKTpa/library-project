package ru.kk.libraryproject.service;

import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllByGenreId(Long id);
    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);


}
