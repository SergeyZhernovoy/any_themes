package com.boot.edu.healthcare.controllers;/**
 * @author Sergey Zhernovoy
 * create on 31.12.2017.
 */

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/signup/process")
    public String processSignup(ModelMap model,
                                @RequestParam String nickname,
                                @RequestParam String emailAddress,
                                @RequestParam String password){
        model.addAttribute("login",true);
        model.addAttribute("nickname",nickname);
        return "index";
    }

}

    