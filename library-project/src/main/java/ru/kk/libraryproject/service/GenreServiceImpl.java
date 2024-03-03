package ru.kk.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kk.libraryproject.dto.AuthorDto;
import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.dto.GenreDto;
import ru.kk.libraryproject.model.Author;
import ru.kk.libraryproject.model.Book;
import ru.kk.libraryproject.model.Genre;
import ru.kk.libraryproject.repository.BookRepository;
import ru.kk.libraryproject.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        List<Book> booksByGenre = bookRepository.findAllByGenreId(id);
        return convertEntityToDto(genre, booksByGenre);
    }

    private GenreDto convertEntityToDto(Genre genre, List<Book> books) {
        List<BookDto> bookDtoList = books.stream()
                .filter(book -> book.getGenre().getId().equals(genre.getId()))
                .map(this::convertBookToDto)
                .collect(Collectors.toList());
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookDtoList)
                .build();
    }

       private BookDto convertBookToDto (Book book) {
        List<AuthorDto> authorDtos = book.getAuthors().stream()
                .map(this::convertAuthorToDto)
                .toList();
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authors(authorDtos)
                .genre(book.getGenre().getName())
                .build();
    }
    private AuthorDto convertAuthorToDto (Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }
}
