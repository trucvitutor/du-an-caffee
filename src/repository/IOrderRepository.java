package repository;

import model.Order;

import java.util.List;

public interface IOrderRepository {
    void addOrderAll(Order order);

    List<Order> findAll();

}
