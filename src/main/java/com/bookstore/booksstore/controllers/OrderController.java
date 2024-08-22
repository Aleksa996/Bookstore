package com.bookstore.booksstore.controllers;

import com.bookstore.booksstore.entities.AppUser;
import com.bookstore.booksstore.entities.Order;
import com.bookstore.booksstore.entities.OrderItem;
import com.bookstore.booksstore.repositories.OrderRepository;
import com.bookstore.booksstore.services.OrderService;
import com.bookstore.booksstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String viewUserOrders(Model model){
        AppUser user = userService.getCurrentUser();
        List<Order> orders = orderService.getOrdersByUserId(user.getUserId());
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/orders/{id}/details")
    public String viewOrderDetails(@PathVariable Long id, Model model){
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order " + id));
        List<OrderItem> orderItems = orderService.findOrderItemsByOrder(order);
        model.addAttribute("order", order);
        model.addAttribute("orderItems", orderItems);
        return "order-details";
    }

    @PostMapping("/buy/{bookId}")
    public String buyBook(@PathVariable Long bookId, @RequestParam int quantity, Principal principal){
        String username = principal.getName();
        orderService.addOrderItem(bookId, quantity, username);
        return "redirect:/orders";
    }

}
