package repository;

import model.Person;
import model.Staff;

import java.util.List;

public interface IStaffRepository {
    void addSta(Person staffTypes);

    List<Person> findAllStaff();

    Staff findidStaff(int id);

    void resetStaff(Staff staff);

    void removeStaff(int id);

}
