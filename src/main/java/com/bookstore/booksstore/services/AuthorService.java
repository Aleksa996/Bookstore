package com.bookstore.booksstore.services;

import com.bookstore.booksstore.entities.Author;
import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.repositories.AuthorRepository;
import com.bookstore.booksstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

}
