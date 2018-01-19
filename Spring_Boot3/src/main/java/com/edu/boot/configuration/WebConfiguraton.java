package com.edu.boot.configuration;/**
 * @author Sergey Zhernovoy
 * create on 19.01.2018.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguraton {

    private static Logger logger = LoggerFactory.getLogger(WebConfiguraton.class);
    @Value("${server.ip}")
    private String info;


    @Bean
    public CommandLineRunner values(){
        return args -> {
            logger.info("> The Server IP is: "+info);
        };
    }

}

    