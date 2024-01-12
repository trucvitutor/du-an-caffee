package service;

import model.Order;

import java.util.List;

public interface IOrderService {
//    void addOrderAll(Order order);

    List<Order> findAll();

    void saveOrder(Order order);

    Order findAllOrder(int id);

    void resetOrder(Order order);

    void removeOrder(int id);

}
