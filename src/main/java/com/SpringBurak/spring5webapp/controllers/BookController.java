package com.SpringBurak.spring5webapp.controllers;


import com.SpringBurak.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("list")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }
}
