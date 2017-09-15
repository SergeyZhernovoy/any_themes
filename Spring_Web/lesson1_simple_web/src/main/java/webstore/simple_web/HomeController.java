package webstore.simple_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sergey Zhernovoy
 * create on 12.09.2017.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("greeting","Welcome to Web Store !");
        model.addAttribute("tagline","The one and only amazing webstore");
        return "welcome";
    }
}

    