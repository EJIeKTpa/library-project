package ru.kk.libraryproject.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.kk.libraryproject.dto.BookCreateDto;
import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.dto.BookUpdateDto;
import ru.kk.libraryproject.model.Book;
import ru.kk.libraryproject.model.Genre;
import ru.kk.libraryproject.repository.BookRepository;
import ru.kk.libraryproject.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        System.out.println("Находим книгу по id" + book);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        System.out.println("поиск книги по имени 1 способ" + book);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV2(String name) {
        Book book = bookRepository.findBookByNameBySql(name).orElseThrow();
        System.out.println("поиск книги по имени 2 способ" + book);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV3(String name) {
        Specification<Book> bookSpecification = Specification.where((Specification<Book>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name));
        Book book = bookRepository.findOne(bookSpecification).orElseThrow();
        System.out.println("поиск книги по имени 3 способ" + book);
        return convertEntityToDto(book);
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        Book book = bookRepository.save(convertDtoToEntity(bookCreateDto));
        BookDto bookDto = convertEntityToDto(book);
        System.out.println("Создаем книгу" + bookDto);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        Book book = bookRepository.findById(bookUpdateDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Book not found")
        );
        book.setName(bookUpdateDto.getName());
        Genre genre = genreRepository.findGenreByName(bookUpdateDto.getGenre()).orElseThrow(
                () -> new EntityNotFoundException("Genre not found")
        );
        book.setGenre(genre);
        Book savedBook = bookRepository.save(book);
        return convertEntityToDto(savedBook);
    }


    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        Genre genre = genreRepository.findGenreByName(bookCreateDto.getGenre()).orElseThrow(
                () -> new EntityNotFoundException("Genre not found")
        );
        return Book.builder()
                .name(bookCreateDto.getName())
                .genre(genre)
                .build();
    }

    private BookDto convertEntityToDto(Book book) {
        return BookDto.builder()
                .name(book.getName())
                .id(book.getId())
                .genre(book.getGenre().getName())
                .build();
    }
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
}
