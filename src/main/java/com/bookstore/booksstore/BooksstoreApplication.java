package com.bookstore.booksstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bookstore.booksstore")
public class BooksstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BooksstoreApplication.class, args);
	}
}
