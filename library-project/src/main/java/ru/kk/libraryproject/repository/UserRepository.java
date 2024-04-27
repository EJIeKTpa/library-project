package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kk.libraryproject.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
