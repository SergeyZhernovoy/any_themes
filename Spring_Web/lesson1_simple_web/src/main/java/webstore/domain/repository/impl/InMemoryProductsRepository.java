package webstore.domain.repository.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;
import webstore.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductsRepository implements ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        Map<String, Object> params = new HashMap<>();
        List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
        return result;
    }

    @Override
    public void updateStock(String productId, long noOfUnits) {
        final String SQL = "update products set units_in_stock = :unitsInStock where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("unitsInStock", noOfUnits);
        params.put("id",productId);
        jdbcTemplate.update(SQL, params);
    }

    private static final class ProductMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getString("ID"));
            product.setName(rs.getString("NAME"));
            product.setDescription(rs.getString("DESCRIPTION"));
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
            product.setManufactured(rs.getString("MANUFACTURER"));
            product.setCategory(rs.getString("CATEGORY"));
            product.setCondition(rs.getString("CONDITION"));
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscounted(rs.getBoolean("DISCONTINUED"));
            return product;
        }
    }

    @Override
    public Product getProductById(final String productId) {
        String SQL = "SELECT * FROM PRODUCTS WHERE id =:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", productId);
        return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY =:category";
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filter) {
        final String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY IN (:categories ) AND MANUFACTURER IN (:brands)";
        return jdbcTemplate.query(SQL, filter, new ProductMapper());
    }


    @Override
    public void addProduct(Product product) {
        String SQL = "INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, UNIT_PRICE,MANUFACTURER,CATEGORY,CONDITION,UNITS_IN_STOCK,"
                   + "UNITS_IN_ORDER,DISCONTINUED) "
                   + "VALUES (:id, :name, :desc, :price, :manufacturer, :category, :condition, :inStock,:inOrder, :discontinued)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", product.getProductId());
        params.put("name", product.getName());
        params.put("desc", product.getDescription());
        params.put("price", product.getUnitPrice());
        params.put("manufacturer", product.getManufactured());
        params.put("category", product.getCategory());
        params.put("condition", product.getCondition());
        params.put("inStock", product.getUnitsInStock());
        params.put("inOrder", product.getUnitsInOrder());
        params.put("discontinued", product.isDiscounted());
        jdbcTemplate.update(SQL, params);
    }
}

    