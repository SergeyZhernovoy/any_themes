package com.edu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergey Zhernovoy
 * create on 05.01.2018.
 */

@SpringBootApplication
@RestController
public class MainApplication {

    @RequestMapping("/")
    public String getGreeting(){
        return "<h1>Spring Boot rulezzz </h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }

}

    