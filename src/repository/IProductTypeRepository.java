package repository;

import model.Product;
import model.ProductType;

import java.util.List;

public interface IProductTypeRepository {
    List<ProductType> findProduct();

}
