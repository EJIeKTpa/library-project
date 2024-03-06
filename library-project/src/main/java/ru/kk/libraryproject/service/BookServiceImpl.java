package ru.kk.libraryproject.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.kk.libraryproject.dto.AuthorDto;
import ru.kk.libraryproject.dto.BookCreateDto;
import ru.kk.libraryproject.dto.BookDto;
import ru.kk.libraryproject.model.Author;
import ru.kk.libraryproject.model.Book;
import ru.kk.libraryproject.model.Genre;
import ru.kk.libraryproject.repository.BookRepository;
import ru.kk.libraryproject.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Override
    public List<Book> findAllByGenreId(Long id) {
        return null;
    }

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
        Specification<Book> bookSpecification = Specification.where(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"), name);
            }
        });
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

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        Genre genre = genreRepository.findById(bookCreateDto.getGenre());
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
}
