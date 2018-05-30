package webstore.dto;

import java.io.Serializable;

public class CartItemDto implements Serializable {
	
	private static final long serialVersionUID = 7592640331820451618L;
	private String id;
	private String productId;
	private int quantity;
	
	public CartItemDto(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

