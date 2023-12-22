package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kk.libraryproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
