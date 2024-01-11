package service;

import model.Person;
import model.Staff;
import repository.IStaffRepository;
import repository.StaffRepository;

import java.util.List;

public class StaffService implements IStaffService {
private static IStaffRepository iStaffRepository=new StaffRepository();

    @Override
    public void addSta(Person staffTypes) {
        iStaffRepository.addSta(staffTypes);
    }

    @Override
    public List<Person> findAllStaff() {
        return iStaffRepository.findAllStaff();
    }

    @Override
    public Staff findidStaff(int id) {
        return iStaffRepository.findidStaff(id);
    }

    @Override
    public void resetStaff(Staff staff) {
        iStaffRepository.resetStaff(staff);
    }

    @Override
    public void removeStaff(int id) {
        iStaffRepository.removeStaff(id);
    }
}
