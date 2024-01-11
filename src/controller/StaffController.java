package controller;

import model.Person;
import model.Staff;
import service.IStaffService;
import service.StaffService;

import java.util.List;

public class StaffController {
    private static IStaffService iStaffService=new StaffService();

    public static void addSta(Person staffTypes) {
        iStaffService.addSta(staffTypes);
    }

    public static Staff findidStaff(int id) {

        return iStaffService.findidStaff(id);
    }

    public static void removeStaff(int id) {
        iStaffService.removeStaff(id);
    }

    public List<Person> findAllStaff() {
      return iStaffService.findAllStaff();
    }

    public void resetStaff(Staff staff) {
        iStaffService.resetStaff(staff);
    }
}
