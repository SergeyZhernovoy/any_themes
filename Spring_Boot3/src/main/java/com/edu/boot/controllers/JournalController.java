package com.edu.boot.controllers;

import com.edu.boot.domain.JournalEntry;
import com.edu.boot.repository.JournalRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class JournalController {

    private static final String VIEW_NAME = "index";
    @Autowired
    private JournalRepositroy repo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_NAME);
        modelAndView.addObject("journal",repo.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/journal",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public List<JournalEntry> getJournal(){
        return repo.findAll();
    }

}
