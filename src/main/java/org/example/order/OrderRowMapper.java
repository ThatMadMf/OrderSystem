package org.example.order;

import org.example.customer.Customer;
import org.example.product.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

@Service
public class OrderRowMapper implements RowMapper<OrderDto> {

    @Override
    public OrderDto mapRow(ResultSet rs, int rowNum) {
        try {
            OrderDto order = (new BeanPropertyRowMapper<>(OrderDto.class).mapRow(rs, rowNum));
            Customer customer = (new BeanPropertyRowMapper<>(Customer.class).mapRow(rs, rowNum));
            Product product = (new BeanPropertyRowMapper<>(Product.class).mapRow(rs, rowNum));
            order.setCustomer(customer);
            order.setProduct(product);

            return order;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
