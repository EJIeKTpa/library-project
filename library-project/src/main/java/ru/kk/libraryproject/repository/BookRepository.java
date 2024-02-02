package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.kk.libraryproject.model.Book;

import java.util.List;
import java.util.Optional;

    public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    List<Book> findAllByGenreId(Long id);
    Optional<Book> findBookByName(String name);
    @Query(nativeQuery = true, value = "Select * from book where name = ?")
    Optional<Book> findBookByNameBySql(String name);

}
