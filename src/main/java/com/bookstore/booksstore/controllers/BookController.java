package com.bookstore.booksstore.controllers;

import com.bookstore.booksstore.DTO.BookDTO;
import com.bookstore.booksstore.DTO.ReviewDTO;
import com.bookstore.booksstore.entities.AppUser;
import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.entities.Review;
import com.bookstore.booksstore.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            List<ReviewDTO> reviews = book.getReviews().stream()
                    .map(review -> new ReviewDTO(
                            review.getRating(),
                            review.getComment(),
                            review.getUser().getUsername(),
                            review.getReviewDate()
                    ))
                    .collect(Collectors.toList());

            BookDTO bookDTO = new BookDTO(
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor().getName(),
                    book.getPublisher().getName(),
                    book.getCategory().getName(),
                    book.getPrice(),
                    book.getPublishedDate(),
                    book.getIsbn(),
                    book.getStockQuantity(),
                    reviews
            );

            return ResponseEntity.ok(bookDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @PostMapping("/books/{bookId}/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long bookId, @RequestBody ReviewDTO reviewDto, Principal principal) {

        Book book = bookService.getBookById(bookId);
        AppUser user = userService.findByUsername(principal.getName());

        Review review = new Review();
        review.setBook(book);
        review.setUser(user);
        review.setRating(reviewDto.getRating());
        review.setComment(reviewDto.getComment());
        review.setReviewDate(new Date());

        reviewService.saveReview(review);

        return ResponseEntity.ok("Review added successfully");
    }

}
