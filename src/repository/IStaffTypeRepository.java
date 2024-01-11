package repository;

import model.CustomerType;
import model.StaffType;

import java.util.List;

public interface IStaffTypeRepository {
    List<StaffType> findAll();
}
