package webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = -7701364810879133810L;
	
	public String getId() {
		return id;
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public BigDecimal getGrandTotal() {
		updateGrandTotal();
		return grandTotal;
	}
	
	private void updateGrandTotal() {
		Function<CartItem, BigDecimal> totalMaper = cartItem -> cartItem.getTotalPrice();
		BigDecimal grandTotal = cartItems.stream()
				.map(totalMaper)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		this.setGrandTotal(grandTotal);
	}
	
	public CartItem getItemByProductId(String id) {
		return cartItems.stream()
				.filter(cartItem -> cartItem.getProduct().getProductId().equals(id))
				.findAny()
				.orElse(null);
	}
	
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	private String id;
	private List<CartItem> cartItems;
	private BigDecimal grandTotal;
	
	public Cart(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cart cart = (Cart) o;
		return Objects.equals(id, cart.id) &&
				Objects.equals(cartItems, cart.cartItems) &&
				Objects.equals(grandTotal, cart.grandTotal);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, cartItems, grandTotal);
	}
}
