package com.libraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.libraryapp.model.Book;
import com.libraryapp.services.BookService;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "home";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("add")
    public String addBook(@ModelAttribute Book book, RedirectAttributes redirectAttrs) {
        bookService.addBook(book);
        redirectAttrs.addFlashAttribute("message", "Book added successfully!");
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit";
    }

    @PostMapping("update")
    public String updateBook(@ModelAttribute Book book, RedirectAttributes redirectAttrs) {
        bookService.updateBook(book);
        redirectAttrs.addFlashAttribute("message", "Book updated successfully!");
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable int id, RedirectAttributes redirectAttrs) {
        bookService.deleteBook(id);
        redirectAttrs.addFlashAttribute("message", "Book deleted successfully!");
        return "redirect:/";
    }
}
