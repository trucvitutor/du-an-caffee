package repository;

import common.FileService;
import model.Product;

import java.util.List;

public class ProductRepository implements IProductRepository {
    public static final String PRODUCT = "src/data/Product.txt";

    @Override
    public void saveProduct(Product product) {
        FileService<Product> fileService = new FileService<>();
        List<Product> productList = fileService.readFile(PRODUCT);
        productList.add(product);
        fileService.writeFile(PRODUCT, productList);
    }

    @Override
    public List<Product> findAllProduct() {
        FileService<Product> fileService = new FileService<>();
        List<Product> productList = fileService.readFile(PRODUCT);
        return productList;
    }

    @Override
    public Product findIdProduct(int id) {
        FileService<Product> fileService = new FileService<>();
        List<Product> productList = fileService.readFile(PRODUCT);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void editPro(Product product) {
        FileService<Product> fileService = new FileService<>();
        List<Product> productList = fileService.readFile(PRODUCT);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setProductType(product.getProductType());
            }
        }
        fileService.writeFile(PRODUCT, productList);
    }

    @Override
    public void removeProduct(int id) {
        FileService<Product> fileService = new FileService<>();
        List<Product> productList = fileService.readFile(PRODUCT);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(productList.get(i));
            }
        }
        fileService.writeFile(PRODUCT, productList);
    }
}

