package webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Sergey Zhernovoy
 * create on 08.10.2017.
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String doLogin(){
        return "login";
    }

    @RequestMapping(value = "/loginfail",method = RequestMethod.GET)
    public String getLoginError(Model model){
        model.addAttribute("error","true");
        return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String doLogout(){
        return "login";
    }

}

    