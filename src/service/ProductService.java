package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private static IProductRepository iProductRepository=new ProductRepository();

    @Override
    public void saveProduct(Product product) {
        iProductRepository.saveProduct(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return iProductRepository.findAllProduct();
    }

    @Override
    public Product findIdProduct(int id) {
        return iProductRepository.findIdProduct(id);
    }

    @Override
    public void editPro(Product product) {
        iProductRepository.editPro(product);
    }

    @Override
    public void removeProduct(int id) {
        iProductRepository.removeProduct(id);
    }
}
