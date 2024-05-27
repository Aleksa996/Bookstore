package com.bookstore.booksstore.controllers;

import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.services.AuthorService;
import com.bookstore.booksstore.services.BookService;
import com.bookstore.booksstore.services.CategoryService;
import com.bookstore.booksstore.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/delete")
    public String delete(@RequestParam("bookId") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "book-form";
    }

    @PostMapping("/books/save")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/update")
    public String updateBook(@RequestParam("bookId") Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "book-form";
    }

}
