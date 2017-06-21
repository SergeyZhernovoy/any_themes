package ru.bibl.web.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bibl.web.domain.User;

/**
 * @author Sergey Zhernovoy
 * create on 21.06.2017.
 */

@Controller
@Scope("session")
public class LoginController {

    @RequestMapping({"/","/login"})
    public String onStartUp(ModelMap model){
        model.addAttribute("User", new User());
        return "login";
    }

    @RequestMapping("/onLogin")
    public String onLogin(@ModelAttribute("User") User user,ModelMap model){
        if(!"junit".equals(user.getUserName())){
            model.addAttribute("error","invalid login name");
            return "login";
        }

        if(!"password".equals(user.getPassword())){
            model.addAttribute("error","invalid password");
            return "login";
        }

        model.addAttribute("name","junit reader");
        return "greetings";

    }

}

    