package webstore.domain.repository;

import webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    void updateStock(String id, long noOfUnits);

    Product getProductById(String productId);

    List<Product> getProductByCategory(String category);

    List<Product> getProductsByFilter(Map<String,List<String>> filter);

    void addProduct(Product product);

}
