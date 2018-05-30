package webstore.domain.repository.impl;

import org.springframework.jdbc.core.RowMapper;
import webstore.domain.CartItem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemMapper implements RowMapper<CartItem> {
	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		return null;
	}
}
