package org.example.order;

import org.example.util.ResourceReader;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderRepository {

    private static final String RESOURCE_PATH = "sql/order/";
    private static final String GET_ALL_ORDERS = getSql("get_all_orders.sql");
    private static final String ADD_NEW_ORDER = getSql("add_new_order.sql");
    private static final String GET_DELIVERY_BY_ORDER_ID = getSql("get_delivery_by_order_id.sql");
    private static final String BIND_DELIVERY_TO_ORDER = getSql("bind_order_delivery.sql");

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<OrderDto> orderRowMapper;
    private final BeanPropertyRowMapper<Delivery> deliveryRowMapper;

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }

    public OrderRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
        orderRowMapper = new BeanPropertyRowMapper<>(OrderDto.class);
        deliveryRowMapper = new BeanPropertyRowMapper<>(Delivery.class);
    }

    public List<OrderDto> getAllOrdersDto() {
        return jdbcTemplate.query(GET_ALL_ORDERS, orderRowMapper);
    }

    @Transactional
    public void addNewOrder(OrderDto orderDto) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("customer_id", orderDto.getCustomerId())
                .addValue("product_id", orderDto.getProductId())
                .addValue("amount", orderDto.getAmount())
                .addValue("order_date", orderDto.getOrderDate());

        namedParameterJdbcTemplate.update(ADD_NEW_ORDER, parameterSource, holder);
        if (orderDto.getDeliveryId() != null) {
            jdbcTemplate.update(BIND_DELIVERY_TO_ORDER, holder.getKey().intValue(), orderDto.getDeliveryId());
        }
    }

    public Delivery getDeliveryById(int orderId) {
        try {
            return jdbcTemplate.queryForObject(GET_DELIVERY_BY_ORDER_ID, new Object[]{orderId}, deliveryRowMapper);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("Delivery is not found for this order");
            return null;
        }
    }
}
