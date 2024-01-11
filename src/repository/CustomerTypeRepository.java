package repository;

import common.FileService;
import model.CustomerType;

import java.util.Arrays;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    public static final String CUSTOMER_TYPE = "src/data/typeCustomer.txt";

    public List<CustomerType> findAll() {
        FileService<CustomerType> customerTypeFileService = new FileService<>();
        List<CustomerType> customerTypes = Arrays.asList(new CustomerType(1, "Kim Cương"), new CustomerType(2, "Vàng"), new CustomerType(3, "Bạc"), new CustomerType(4, "Đồng"), new CustomerType(5, "Thành Viên"));
        customerTypeFileService.writeFile(CUSTOMER_TYPE, customerTypes);
        return customerTypeFileService.readFile(CUSTOMER_TYPE);
    }

}
