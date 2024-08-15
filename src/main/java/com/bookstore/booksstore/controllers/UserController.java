package com.bookstore.booksstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    @GetMapping("/user")
    public String user(Principal principal) {
        return "Logged in as: " + principal.getName();
    }
}
