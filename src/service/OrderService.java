package service;

import repository.IOrderRepository;
import repository.OrderRepository;

public class OrderService implements IOrderService {
    private static IOrderRepository iOrderRepository=new OrderRepository();

}
