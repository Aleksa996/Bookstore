package com.bookstore.booksstore.services;

import com.bookstore.booksstore.entities.AppUser;
import com.bookstore.booksstore.entities.Book;
import com.bookstore.booksstore.entities.Order;
import com.bookstore.booksstore.entities.OrderItem;
import com.bookstore.booksstore.repositories.AppUserRepository;
import com.bookstore.booksstore.repositories.BookRepository;
import com.bookstore.booksstore.repositories.OrderItemRepository;
import com.bookstore.booksstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private BookRepository bookRepository;


    public List<Order> getAllOrderItem(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByUserId(Long userId){
        return orderRepository.findByUserUserId(userId);
    }

    public AppUser findAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public List<OrderItem> findOrderItemsByOrder(Order order){
        return orderItemRepository.findByOrder(order);
    }

    public void addOrderItem(Long bookId, int quantity, String username){
        AppUser user = appUserRepository.findByUsername(username);

        Order order = orderRepository.findByUserAndStatus(user, "OPEN")
                .orElseGet(() -> {
                    Order newOrder = new Order();
                    newOrder.setUser(user);
                    newOrder.setOrderDate(new Date());
                    newOrder.setStatus("OPEN");
                    newOrder.setTotalAmount(0.0);
                    return orderRepository.save(newOrder);
                });

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));


        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setBook(book);
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(book.getPrice());

        Double totalPrice = book.getPrice() * quantity;
        order.setTotalAmount(order.getTotalAmount() + totalPrice);

        orderItemRepository.save(orderItem);
        orderRepository.save(order);


    }

}
