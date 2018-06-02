package webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CartItem implements Serializable {
	
	private static final long serialVersionUID = -7972110481592645617L;
	private String id;
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
		this.updateTotalPrice();
	}
	
	private void updateTotalPrice() {
		totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CartItem cartItem = (CartItem) o;
		return quantity == cartItem.quantity &&
				Objects.equals(id, cartItem.id) &&
				Objects.equals(product, cartItem.product) &&
				Objects.equals(totalPrice, cartItem.totalPrice);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(id, product, quantity, totalPrice);
	}
}
