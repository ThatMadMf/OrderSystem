package org.example.order;

import org.example.customer.CustomerRepository;
import org.example.product.ProductRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private static final String RESOURCE_PATH = "sql/order/";
    private static final String GET_ALL_ORDERS = getSql("get_all_orders.sql");

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<OrderDto> rowMapper;

    public OrderRepository(CustomerRepository customerRepository, ProductRepository productRepository,
                           JdbcTemplate jdbcTemplate) {

        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.jdbcTemplate = jdbcTemplate;
        rowMapper = new BeanPropertyRowMapper<>(OrderDto.class);
    }

    public List<Order> getAllOrders() {
       return jdbcTemplate.query(GET_ALL_ORDERS, rowMapper).stream()
               .map(x -> new Order(
                       x.getId(),
                       customerRepository.getCustomerById(x.getCustomerId()),
                       productRepository.getProductById(x.getProductId()),
                       x.getAmount(),
                       x.getOrderDate()))
               .collect(Collectors.toList());
    }

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }
}
