package repository;

import common.FileService;
import model.CustomerType;
import model.StaffType;

import java.util.Arrays;
import java.util.List;

public class StaffTypeRepository implements IStaffTypeRepository {
    public static final String STAFF_TYPE = "src/data/typeStaff.txt";

    @Override
    public List<StaffType> findAll() {
        FileService<StaffType> customerTypeFileService = new FileService<>();
        List<StaffType> customerTypes = Arrays.asList(new StaffType(1, "full-time"), new StaffType(2, "Part-time"),
                new StaffType(3, "quản lý"), new StaffType(4, "pha chế "), new StaffType(5, "phục vụ"));
        customerTypeFileService.writeFile(STAFF_TYPE, customerTypes);
        return customerTypeFileService.readFile(STAFF_TYPE);
    }
}
