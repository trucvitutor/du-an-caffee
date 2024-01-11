package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    void saveProduct(Product product);

    List<Product> findAllProduct();

    Product findIdProduct(int id);

    void editPro(Product product);

    void removeProduct(int id);

}
