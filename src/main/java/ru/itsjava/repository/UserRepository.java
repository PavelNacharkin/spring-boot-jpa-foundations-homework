package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ru.itsjava.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("DELETE FROM Users u WHERE u.id = ?1")
    void deleteById(long id);
}

