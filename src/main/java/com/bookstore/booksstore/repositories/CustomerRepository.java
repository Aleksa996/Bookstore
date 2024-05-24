package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
