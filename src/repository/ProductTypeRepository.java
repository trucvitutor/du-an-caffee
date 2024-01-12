package repository;

import common.FileService;
import model.Product;
import model.ProductType;
import model.StaffType;

import java.util.Arrays;
import java.util.List;

public class ProductTypeRepository implements IProductTypeRepository {
    public static final String TYPE_PRODUCT = "src/data/typeProduct.txt";


    @Override
    public List<ProductType> findProduct() {
        FileService<ProductType> customerTypeFileService = new FileService<>();
        List<ProductType> fileServices = Arrays.asList(new ProductType(1, "Cà phê "),
                new ProductType(2, "trà "), new ProductType(3, " nước giải khát "));
        customerTypeFileService.writeFile(TYPE_PRODUCT, fileServices);
        return customerTypeFileService.readFile(TYPE_PRODUCT);
    }
}
