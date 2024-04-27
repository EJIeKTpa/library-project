package ru.kk.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kk.libraryproject.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
