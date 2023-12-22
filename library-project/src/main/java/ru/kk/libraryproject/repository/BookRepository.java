package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kk.libraryproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
