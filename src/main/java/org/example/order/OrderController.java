package org.example.order;

import org.example.util.SubmitFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("new-order")
    public String newOrder(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        return "new-order";
    }

    @PostMapping("new-order")
    public String processNewOrder(@ModelAttribute OrderDto orderDto, Model model) {
        try {
            orderDto.setOrderDate(new Date());

            orderService.addNewOrder(orderDto);
            model.addAttribute("success", true);

            return "new-order-result";

        } catch (RuntimeException ex) {

            throw new SubmitFailedException(ex.getMessage());
        }
    }
}
