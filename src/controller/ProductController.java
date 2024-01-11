package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import java.util.List;

public class ProductController {
    private static IProductService productService=new ProductService();

    public static void saveProduct(Product product) {
        productService.saveProduct(product);
    }

    public static void editPro(Product product) {
        productService.editPro(product);
    }

    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    public Product findIdProduct(int id) {

        return productService.findIdProduct(id);
    }

    public void removeProduct(int id) {
        productService.removeProduct(id);
    }
}
