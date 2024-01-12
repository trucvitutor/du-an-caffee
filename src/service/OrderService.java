package service;

import model.Order;
import repository.IOrderRepository;
import repository.OrderRepository;

import java.util.List;

public class OrderService implements IOrderService {
    private static IOrderRepository iOrderRepository = new OrderRepository();

//    @Override
//    public void addOrderAll(Order order) {
//        iOrderRepository.addOrderAll(order);
//    }

    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        iOrderRepository.saveOrder(order);
    }

    @Override
    public Order findAllOrder(int id) {
        return iOrderRepository.findAllOrder(id);
    }

    @Override
    public void resetOrder(Order order) {
        iOrderRepository.resetOrder(order);
    }

    @Override
    public void removeOrder(int id) {
        iOrderRepository.removeOrder(id);
    }
}
