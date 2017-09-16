package webstore.controller;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webstore.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public String getCustomers(Model model){
        model.addAttribute("customers",customerService.getAllCustomers());
        return "customers";
    }
}

    