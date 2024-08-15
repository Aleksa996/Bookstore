package com.bookstore.booksstore.DTO;

import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private int rating;
    private String comment;
    private String userName;
    private Date reviewDate;

    public static ReviewDTO toReviewDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setRating(review.getRating());
        reviewDTO.setUserName(review.getUser().getUsername());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setReviewDate(review.getReviewDate());
        return reviewDTO;
    }

}
