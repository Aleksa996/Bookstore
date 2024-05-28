package com.bookstore.booksstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String dashboard(){
        return "/books";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
