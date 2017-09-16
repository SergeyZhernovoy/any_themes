package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webstore.service.ProductService;

/**
 * @author Sergey Zhernovoy
 * create on 14.09.2017.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/all")
    public String listProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public ModelAndView getProductsByCategory(@PathVariable String category, ModelAndView modelAndView){
        modelAndView.setViewName("products");
        modelAndView.addObject("products",this.productService.getPrpductByCategory(category));
        return modelAndView;
    }

}

    