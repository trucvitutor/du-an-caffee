package repository;

import common.FileService;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository{
    private static final String FILE_ORDER="src/data/typeProduct.txt";
    @Override
    public void addOrderAll(Order order) {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList=  fileService.readFile(FILE_ORDER);

    }

    @Override
    public List<Order> findAll() {
        FileService<Order> fileService = new FileService<>();
        List<Order> orderList=  fileService.readFile(FILE_ORDER);
        return orderList;
    }
}
