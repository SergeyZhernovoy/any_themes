package com.boot.edu.healthcare.interceptors;/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupInterceptors extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String emailAddress = request.getParameter("emailAddress");
            String password = request.getParameter("password");
            if(StringUtils.isEmpty(emailAddress) || StringUtils.isEmpty(password)
            || StringUtils.containsWhitespace(emailAddress) || StringUtils.containsWhitespace(password)){
                throw new Exception("Invalid Email or Password. Please try again ...");
            }
            return true;
    }
}

    