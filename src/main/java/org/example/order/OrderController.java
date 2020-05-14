package org.example.order;

import org.example.util.SubmitFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order/orders";
    }

    @GetMapping("new-order")
    public String newOrder(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        return "order/new-order";
    }

    @PostMapping("new-order")
    public String processNewOrder(@ModelAttribute OrderDto orderDto, Model model) {
        try {
            orderDto.setOrderDate(new Date());

            orderService.addNewOrder(orderDto);
            model.addAttribute("success", true);

            return "order/new-order-result";

        } catch (RuntimeException ex) {

            throw new SubmitFailedException(ex.getMessage());
        }
    }
}
