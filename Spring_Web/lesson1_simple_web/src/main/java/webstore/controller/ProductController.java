package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webstore.domain.Product;
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

    @RequestMapping(value = "/{category}/{price}",method = RequestMethod.GET)
    public String getFilteredGrids(@PathVariable String category,@MatrixVariable(pathVar = "price") Map<String,Integer> range,@RequestParam String manufacturer){
        return "products";
    }

    @RequestMapping("")
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

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAddProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("product") Product newProduct){
        productService.addProduct(newProduct);
        return "redirect:/products";
    }
}

    