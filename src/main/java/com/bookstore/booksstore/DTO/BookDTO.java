package com.bookstore.booksstore.DTO;

import com.bookstore.booksstore.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private String categoryName;
    private double price;
    private String publishedDate;
    private String isbn;
    private int stockQuantity;

    public static BookDTO toBookDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthorName(book.getAuthor().getName());
        bookDTO.setPublisherName(book.getPublisher().getName());
        bookDTO.setCategoryName(book.getCategory().getName());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setPublishedDate(book.getPublishedDate());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setStockQuantity(book.getStockQuantity());
        return bookDTO;
    }

}
