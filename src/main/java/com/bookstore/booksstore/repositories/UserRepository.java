package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
