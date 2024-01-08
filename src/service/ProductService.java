package service;

import repository.IProductRepository;
import repository.ProductRepository;

public class ProductService implements IProductService {
    private static IProductRepository iProductRepository=new ProductRepository();
}
