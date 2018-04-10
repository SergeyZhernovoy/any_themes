package webstore.controller;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webstore.domain.Customer;
import webstore.domain.Product;
import webstore.service.CustomerService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getCustomers(Model model){
        model.addAttribute("customers",customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAddCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "addCustomer";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("customer") Customer newCustomer, BindingResult result, HttpServletRequest request){
        customerService.addCustomer(newCustomer);
        return "redirect:/customers";
    }

}

    