package ru.szhernovoy.test.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.szhernovoy.test.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 22.06.2017.
 */

@Controller
@Scope("session")
public class LoginController {

    public List<User> users = new ArrayList<>();

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView getLoginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/onLogin"}, method = RequestMethod.POST)
    public String getLoginPage(@ModelAttribute("User")User user, ModelMap model, HttpSession session, HttpServletRequest request){
        if(!"junit".equals(user.getName())){
            model.addAttribute("error","invalid login name");
            return "login";
        }
        if(!"pass".equals(user.getPassword())){
            model.addAttribute("error","invalid password name");
            return "login";
        }

        users.add(user);
        session.setAttribute("userName",request.getParameter("name"));
        model.addAttribute("name","Welcome junit reader");
        return "greetings";
    }

    @RequestMapping(value = "/onLoginDetail",method = RequestMethod.GET)
    public String onloginDetail(ModelMap model){
        if(users.size()> 0){
            User user = users.get(0);
            model.addAttribute("name",user.getName());
            model.addAttribute("password", user.getPassword());
        }

        return "greetings";

    }

}




    