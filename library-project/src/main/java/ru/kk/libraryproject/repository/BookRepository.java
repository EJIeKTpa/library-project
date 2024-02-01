package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kk.libraryproject.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByGenreId(Long id);
}
