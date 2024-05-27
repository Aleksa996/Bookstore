package com.bookstore.booksstore.services;

import com.bookstore.booksstore.entities.Author;
import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.entities.Category;
import com.bookstore.booksstore.entities.Publisher;
import com.bookstore.booksstore.repositories.AuthorRepository;
import com.bookstore.booksstore.repositories.BookRepository;
import com.bookstore.booksstore.repositories.CategoryRepository;
import com.bookstore.booksstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    PublisherRepository publisherRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book){
        Author author = book.getAuthor();
        if(author.getAuthorId() == null){
            authorRepository.save(author);
        }

        Category category = book.getCategory();
        if(category.getCategoryId() == null){
            categoryRepository.save(category);
        }

        Publisher publisher = book.getPublisher();
        if(publisher.getPublisherId() == null){
            publisherRepository.save(publisher);
        }
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
