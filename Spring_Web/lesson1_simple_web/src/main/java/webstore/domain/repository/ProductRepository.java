package webstore.domain.repository;

import webstore.domain.Product;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */
public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);

}
