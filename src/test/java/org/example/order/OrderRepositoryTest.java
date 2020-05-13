package org.example.order;

import org.example.Main;
import org.example.config.DataBaseConfig;
import org.example.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

@SpringBootTest(classes = {Main.class, DataBaseConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class OrderRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testGetAllOrders() {

        List<OrderDto> actualResult = orderRepository.getAllOrdersDto();

        assertNotNull(actualResult);
        assertFalse(actualResult.isEmpty());
    }

    @Test
    public void whenAddingNewOrder_Expect_Success() {
        OrderDto orderDto = new OrderDto(1, 1, 50, new Date());

        assertEquals(orderRepository.addNewOrder(orderDto), 1);
    }
}