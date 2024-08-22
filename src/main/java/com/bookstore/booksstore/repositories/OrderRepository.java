package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.AppUser;
import com.bookstore.booksstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserUserId(Long userId);

    Optional<Order> findByUserAndStatus(AppUser user, String status);
}
