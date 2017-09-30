package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import webstore.service.ProductService;

import java.util.List;
import java.util.Map;

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
        modelAndView.addObject("products",this.productService.getProductByCategory(category));
        return modelAndView;
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String,List<String>> filter,  Model model){
        model.addAttribute("products",productService.getProductsByFilter(filter));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam String id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "product";
    }

}

    