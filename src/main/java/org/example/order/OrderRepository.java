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
    private static final String GET_DELIVERY_BY_ORDER_ID = getSql("get_delivery_by_order_id.sql");

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<OrderDto> orderRowMapper;
    private final BeanPropertyRowMapper<Delivery> deliveryRowMapper;

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        orderRowMapper = new BeanPropertyRowMapper<>(OrderDto.class);
        deliveryRowMapper = new BeanPropertyRowMapper<>(Delivery.class);
    }

    public List<OrderDto> getAllOrdersDto() {
        return jdbcTemplate.query(GET_ALL_ORDERS, orderRowMapper);
    }

    public int addNewOrder(OrderDto orderDto) {
        return jdbcTemplate.update(ADD_NEW_ORDER, orderDto.getCustomerId(), orderDto.getProductId(),
                orderDto.getAmount(), orderDto.getOrderDate());
    }

    public Delivery getDeliveryById(int orderId) {
        return jdbcTemplate.queryForObject(GET_DELIVERY_BY_ORDER_ID, new Object[]{orderId}, deliveryRowMapper);
    }


}
