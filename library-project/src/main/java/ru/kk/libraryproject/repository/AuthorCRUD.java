package ru.kk.libraryproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kk.libraryproject.model.Author;

import java.util.List;

@Repository
public interface AuthorCRUD extends CrudRepository <Author, Long> {
    List<Author> findAllByNameContaining(String name, String surname);
}
