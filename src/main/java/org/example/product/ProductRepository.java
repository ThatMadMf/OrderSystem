package org.example.product;

import org.example.order.ResourceReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private static final String RESOURCE_PATH = "sql/product/";
    private static final String GET_PRODUCT_BY_ID = getSql("get_product_by_id.sql");

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Product> rowMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        rowMapper = new BeanPropertyRowMapper<>(Product.class);
    }

    public Product getProductById(int id) {
        return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new Object[]{id}, rowMapper);
    }

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }
}
