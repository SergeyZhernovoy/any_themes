package webstore.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartDto implements Serializable {
	private String id;
	private List<CartItemDto> cartItems;
	
	public CartDto() {
	}
	
	public CartDto(String id) {
		this.id = id;
		cartItems = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	
	public List<CartItemDto> getCartItems() {
		return cartItems;
	}
	
	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addCartItem(CartItemDto cartItemDto) {
		this.cartItems.add(cartItemDto);
	}
	
}
