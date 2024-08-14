package com.bookstore.booksstore.controllers;

import com.bookstore.booksstore.entities.Author;
import com.bookstore.booksstore.entities.Category;
import com.bookstore.booksstore.services.AuthorService;
import com.bookstore.booksstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/category/delete")
    public String delete(@RequestParam("categoryId") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping("/category/new")
    public String newCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "category-form";
    }

    @PostMapping("/category/save")
    public String saveCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/update")
    public String updateCategory(@RequestParam("categoryId") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category-form";
    }

}
