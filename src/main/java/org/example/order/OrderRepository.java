package org.example.order;

import org.example.util.ResourceReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private static final String RESOURCE_PATH = "sql/order/";
    private static final String GET_ALL_ORDERS = getSql("get_all_orders.sql");
    private static final String ADD_NEW_ORDER = getSql("add_new_order.sql");

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<OrderDto> rowMapper;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        rowMapper = new BeanPropertyRowMapper<>(OrderDto.class);
    }

    public List<OrderDto> getAllOrdersDto() {
        return jdbcTemplate.query(GET_ALL_ORDERS, rowMapper);
    }

    public int addNewOrder(OrderDto orderDto) {
        return jdbcTemplate.update(ADD_NEW_ORDER, orderDto.getCustomerId(), orderDto.getProductId(),
                orderDto.getAmount(), orderDto.getOrderDate());
    }

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

}
