package webstore.domain.repository.impl;

import org.springframework.jdbc.core.RowMapper;
import webstore.domain.CartItem;
import webstore.domain.repository.ProductRepository;
import webstore.service.ProductService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemMapper implements RowMapper<CartItem> {
	private ProductService productService;

	public CartItemMapper(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartItem item = new CartItem(rs.getString("ID"));
		item.setProduct(productService.getProductById(rs.getString("PRODUCT_ID")));
		item.setQuantity(rs.getInt("QUANTITY"));
		return item;
	}
}
