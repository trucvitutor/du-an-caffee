package service;

import model.Product;

import java.util.List;

public interface IProductService {
    void saveProduct(Product product);

    List<Product> findAllProduct();

    Product findIdProduct(int id);

    void editPro(Product product);

    void removeProduct(int id);

}
