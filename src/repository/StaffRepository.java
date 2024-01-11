package repository;

import common.FileService;
import model.Person;
import model.Staff;

import java.util.List;
import java.util.Objects;

public class StaffRepository implements IStaffRepository {
    private static final String STAFF = "src/data/staff.txt";

    @Override
    public void addSta(Person staffTypes) {
        FileService<Person> fileService = new FileService<>();
        List<Person> list = fileService.readFile(STAFF);
        list.add(staffTypes);
        fileService.writeFile(STAFF, list);
    }

    @Override
    public List<Person> findAllStaff() {
        FileService<Person> fileService = new FileService<>();
        List<Person> list = fileService.readFile(STAFF);
        return list;
    }

    @Override
    public Staff findidStaff(int id) {
        FileService<Person> fileService = new FileService<>();
        List<Person> list = fileService.readFile(STAFF);
        for (Person s : list) {
            if (s.getId() == id) {
                return (Staff) s;
            }
        }
        return null;
    }

    @Override
    public void resetStaff(Staff staff) {
        FileService<Person> fileService = new FileService<>();
        List<Person> list = fileService.readFile(STAFF);
        for (Person a : list) {
            if (a instanceof Staff) {
                if (Objects.equals(a.getId(), staff.getId())) {
                    a.setCode(staff.getCode());
                    a.setName(staff.getName());
                    a.setGmail(staff.getGmail());
                    a.setPhoneNumber(staff.getPhoneNumber());
                    ((Staff) a).setIdCard(staff.getIdCard());
                    ((Staff) a).setSalary(staff.getSalary());
                    ((Staff) a).setStaffType(staff.getStaffType());
                    ((Staff) a).setAddress(staff.getAddress());
                    break;
                }
            }
        }
        fileService.writeFile(STAFF, list);
    }

    @Override
    public void removeStaff(int id) {
        FileService<Person> fileService = new FileService<>();
        List<Person> list = fileService.readFile(STAFF);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id){
                list.remove(list.get(i));
            }
        }
        fileService.writeFile(STAFF, list);
    }
}
