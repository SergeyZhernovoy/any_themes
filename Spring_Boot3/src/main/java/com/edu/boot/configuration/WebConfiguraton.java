package com.edu.boot.configuration;/**
 * @author Sergey Zhernovoy
 * create on 19.01.2018.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguraton {
    @Value("${server.ip}")
    private String info;
}

    