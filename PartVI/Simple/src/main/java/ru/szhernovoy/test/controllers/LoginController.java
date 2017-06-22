package ru.szhernovoy.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.szhernovoy.test.models.User;

/**
 * @author Sergey Zhernovoy
 * create on 22.06.2017.
 */

@Controller
public class LoginController {

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView getLoginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/onLogin"}, method = RequestMethod.POST)
    public String getLoginPage(@ModelAttribute("User")User user, ModelMap model){
        if(!"junit".equals(user.getName())){
            model.addAttribute("error","invalid login name");
            return "login";
        }
        if(!"pass".equals(user.getPassword())){
            model.addAttribute("error","invalid password name");
            return "login";
        }

        model.addAttribute("name","junit reader");
        return "greetings";
    }
}




    