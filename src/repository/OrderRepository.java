package repository;

import common.FileService;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static final String FILE_ORDER = "src/data/order.txt";


    @Override
    public List<Order> findAll() {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList = fileService.readFile(FILE_ORDER);
        return orderList;
    }

    @Override
    public void saveOrder(Order order) {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList = fileService.readFile(FILE_ORDER);
        orderList.add(order);
        fileService.writeFile(FILE_ORDER, orderList);
    }

    @Override
    public Order findAllOrder(int id) {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList = fileService.readFile(FILE_ORDER);
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == id) {
                return orderList.get(i);
            }
        }
        return null;
    }

    @Override
    public void resetOrder(Order order) {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList = fileService.readFile(FILE_ORDER);
        for (Order o : orderList) {
            o.setCode(order.getCode());
            o.setStaff(order.getStaff());
            o.setProducts(order.getProducts());
            o.setCustomer(order.getCustomer());

        }
        fileService.writeFile(FILE_ORDER, orderList);

    }

    @Override
    public void removeOrder(int id) {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList = fileService.readFile(FILE_ORDER);
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == id) {
                orderList.remove(orderList.get(i));
            }
        }
        fileService.writeFile(FILE_ORDER, orderList);
    }
}
