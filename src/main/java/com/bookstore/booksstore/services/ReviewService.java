package com.bookstore.booksstore.services;

import com.bookstore.booksstore.entities.Publisher;
import com.bookstore.booksstore.entities.Review;
import com.bookstore.booksstore.repositories.PublisherRepository;
import com.bookstore.booksstore.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview(){
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id){
        return reviewRepository.findById(id).orElse(null);
    }

    public Review saveReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }
}
