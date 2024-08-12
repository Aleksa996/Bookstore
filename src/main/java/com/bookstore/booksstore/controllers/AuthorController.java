package com.bookstore.booksstore.controllers;

import com.bookstore.booksstore.entities.Author;
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
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/authors/delete")
    public String delete(@RequestParam("authorId") Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @GetMapping("/authors/new")
    public String newAuthor(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "author-form";
    }

    @PostMapping("/authors/save")
    public String saveAuthor(@ModelAttribute("author") Author author){
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/update")
    public String updateAuthor(@RequestParam("authorId") Long id, Model model){
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "author-form";
    }

}
