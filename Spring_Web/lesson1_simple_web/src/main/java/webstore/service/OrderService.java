package webstore.service;

/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */
public interface OrderService {
    void processOrder(String productId, int count);
}
