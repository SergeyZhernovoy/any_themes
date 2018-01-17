package com.edu.boot.controllers;

import com.edu.boot.repository.JournalRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JournalController {
    @Autowired
    JournalRepositroy repo;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal",repo.findAll());
        return "index";
    }
}
