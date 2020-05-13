package org.example.order;

import org.example.customer.CustomerRepository;
import org.example.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrdersDto().stream()
                .map(x -> new Order(
                        x.getId(),
                        customerRepository.getCustomerById(x.getCustomerId()),
                        productRepository.getProductById(x.getProductId()),
                        x.getAmount(),
                        x.getOrderDate()))
                .collect(Collectors.toList());
    }
}
