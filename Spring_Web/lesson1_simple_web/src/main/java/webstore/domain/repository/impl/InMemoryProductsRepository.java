package webstore.domain.repository.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.stereotype.Repository;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductsRepository implements ProductRepository {

    private List<Product> products;

    public InMemoryProductsRepository() {
        this.products = new ArrayList<>();

        Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smartphone");
        iphone.setManufactured("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufactured("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufactured("Google");
        tablet_Nexus.setUnitsInStock(1000);
        products.add(iphone);
        products.add(laptop_dell);
        products.add(tablet_Nexus);

    }

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }

    @Override
    public Product getProductById(final String productId) {
        Product product = products
                .stream()
                .filter(prod->{
                    if(prod.getProductId()!= null && prod.getProductId().equals(productId)){
                        return true;
                    } return false;
                }).findFirst().get();

        if (product.getProductId() == null){
            throw new IllegalArgumentException("No product found with ID = "+productId);
        }

        return product;

    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return this.products
                   .stream()
                   .filter(product -> {
                       if(product.getCategory().equals(category)){
                           return true;
                       } return false;
                   })
                   .collect(Collectors.toList());
    }
}

    