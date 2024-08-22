package com.bookstore.booksstore.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CustomLogoutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        // Clear the authentication in Spring Security
        SecurityContextHolder.clearContext();
        // Redirect to the login page
        return "redirect:/login?logout";
    }

}
