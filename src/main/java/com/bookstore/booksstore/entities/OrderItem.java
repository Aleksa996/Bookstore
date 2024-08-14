package com.bookstore.booksstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private int quantity;
    private double unitPrice;

}
