package com.boot.edu.healthcare.controllers;/**
 * @author Sergey Zhernovoy
 * create on 31.12.2017.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account/*")
public class UserAccountController {

    @RequestMapping
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/forgotpassword")
    public String forgotpassword(){
        return "forgotpassword";
    }

}

    