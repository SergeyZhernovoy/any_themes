package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import webstore.service.ProductService;

/**
 * @author Sergey Zhernovoy
 * create on 14.09.2017.
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }
}

    