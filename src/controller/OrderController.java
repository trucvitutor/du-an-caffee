package controller;

import model.Order;
import service.IOrderService;
import service.OrderService;

import java.util.List;

public class OrderController {
    private static IOrderService orderService=new OrderService();

    public void addOrderAll(Order order) {
        orderService.addOrderAll(order);
    }

    public List<Order> findAll() {

        return orderService.findAll();
    }
}
