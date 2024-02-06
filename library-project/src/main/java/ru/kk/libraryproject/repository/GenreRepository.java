package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kk.libraryproject.model.Genre;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
