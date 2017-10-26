package webstore.exception;/**
 * @author Sergey Zhernovoy
 * create on 27.10.2017.
 */

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -2133026056340468065L;
    private String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}

    