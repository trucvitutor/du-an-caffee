package model;

public class Staff extends People {
    private String idCard;
    private double salary;
    private String address;
    private StaffType StaffType;

    public Staff(Integer id, String code, String name, int phoneNumber, String gmail, String idCard, double salary, String address, model.StaffType staffType) {
        super(id, code, name, phoneNumber, gmail);
        this.idCard = idCard;
        this.salary = salary;
        this.address = address;
        StaffType = staffType;
    }

    public Staff(String idCard, double salary, String address, model.StaffType staffType) {
        this.idCard = idCard;
        this.salary = salary;
        this.address = address;
        StaffType = staffType;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idCard='" + idCard + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", StaffType=" + StaffType +
                '}';
    }
}
