package service;

import model.Order;

import java.util.List;

public interface IOrderService {
    void addOrderAll(Order order);

    List<Order> findAll();

}
