package model;

public class Staff extends Person {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public model.StaffType getStaffType() {
        return StaffType;
    }

    public void setStaffType(model.StaffType staffType) {
        StaffType = staffType;
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
