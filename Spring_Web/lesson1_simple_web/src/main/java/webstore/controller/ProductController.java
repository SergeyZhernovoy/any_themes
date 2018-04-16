package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import webstore.domain.Product;
import webstore.exception.NoProductsFoundUnderCategoryException;
import webstore.exception.ProductNotFoundException;
import webstore.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    private ProductService productService;

    @InitBinder
    public void initialiseBinder(WebDataBinder binder){
        binder.setDisallowedFields("unitsInOrder","discounted");
        binder.setAllowedFields("productId",
                                "name",
                                "unitPrice",
                                "manufactured",
                                "description",
                                "category",
                                "unitsInStock",
                                "condition",
                                "productImage",
                                "language");
    }

    @RequestMapping("")
    public String listProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model){
        productService.updateAllStock();
        return "redirect:/products";
    }

    @RequestMapping("/{category}")
    public ModelAndView getProductsByCategory(@PathVariable String category, ModelAndView modelAndView){
        List<Product> products = this.productService.getProductByCategory(category);
        if (products == null || products.isEmpty()){
            throw new NoProductsFoundUnderCategoryException();
        }
        modelAndView.setViewName("products");
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @RequestMapping("/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String,List<String>> filter,  Model model){
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
    public String addNewProduct(@ModelAttribute("product") Product newProduct, BindingResult result, HttpServletRequest request){
        String[] suppressedField = result.getSuppressedFields();
        if(suppressedField.length > 0){
            throw new RuntimeException("Attempting to bind disallowed fields " + StringUtils.arrayToCommaDelimitedString(suppressedField));
        }

        MultipartFile image = newProduct.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if(image != null && !image.isEmpty()){
            try{
                image.transferTo(new File(rootDirectory + "resources\\images\\"+newProduct.getProductId()+".png"));
            } catch (IOException e) {
                throw new RuntimeException("Product Image saving failed",e);
            }
        }

        productService.addProduct(newProduct);
        return "redirect:/products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerException(HttpServletRequest request, ProductNotFoundException exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("invalidProductId",exception.getProductId());
        modelAndView.addObject("exception",exception);
        modelAndView.addObject("url",request.getRequestURL()+"?"+request.getQueryString());
        modelAndView.setViewName("productNotFound");
        return modelAndView;
    }
    
    @RequestMapping("/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }
    
}

    