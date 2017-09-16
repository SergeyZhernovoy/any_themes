package webstore.service;

import webstore.domain.Product;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getPrpductByCategory(String category);

}
