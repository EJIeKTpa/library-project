package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kk.libraryproject.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
