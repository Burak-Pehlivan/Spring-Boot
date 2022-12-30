package com.SpringBurak.spring5webapp.controllers;

import com.SpringBurak.spring5webapp.repositories.AuthorRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("authorList")
    public String getauthor(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authorList";
    }

}
