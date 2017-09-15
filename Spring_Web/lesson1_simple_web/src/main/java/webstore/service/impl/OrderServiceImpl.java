package webstore.service.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;
import webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quality) {
        Product product = productRepository.getProductById(productId);
        if(product.getUnitsInStock() < quality){
            throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ product.getUnitsInStock());
        }
        product.setUnitsInStock(product.getUnitsInStock() - quality);
    }
}

    