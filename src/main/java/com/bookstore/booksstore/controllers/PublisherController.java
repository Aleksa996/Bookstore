package com.bookstore.booksstore.controllers;

import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.entities.Publisher;
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
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String getAllPublishers(Model model) {
        List<Publisher> publishers = publisherService.getAllPublisher();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }

    @GetMapping("/publisher/delete")
    public String delete(@RequestParam("publisherId") Long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }

    @GetMapping("/publisher/new")
    public String newPublisher(Model model){
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "publisher-form";
    }

    @PostMapping("/publisher/save")
    public String saveBook(@ModelAttribute("book") Publisher publisher){
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/publisher/update")
    public String updatePublisher(@RequestParam("publisherId") Long id, Model model){
        Publisher publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "publisher-form";
    }

}
