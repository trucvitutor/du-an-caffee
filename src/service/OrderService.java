package service;

import model.Order;
import repository.IOrderRepository;
import repository.OrderRepository;

import java.util.List;

public class OrderService implements IOrderService {
    private static IOrderRepository iOrderRepository=new OrderRepository();

    @Override
    public void addOrderAll(Order order) {
        iOrderRepository.addOrderAll(order);
    }

    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }
}
