package org.controller;

import org.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * @author Sergey Zhernovoy
 * create on 14.09.2017.
 */

@Controller
public class ProductController {
    @RequestMapping("/products")
    public String listProducts(Model model){
        Product iPhone = new Product("P1234","iPhone 5s",new BigDecimal(500));
        iPhone.setDescription("Apple iPhone 5s smartphone with 4.00-inch\n" +
                "640x1136 display and 8-megapixel rear camera");
        iPhone.setCategory("Smart Phone");
        iPhone.setManufactured("Apple");
        iPhone.setUnitsInStock(1000);
        model.addAttribute("products",iPhone);
        return "products";
    }
}

    