package model;

import java.io.Serializable;

public class Customer extends Person  {
   // private static final long serialVersionUID = 88810112004888L;
    private CustomerType customerType;

    public Customer(Integer id, String code, String name, int phoneNumber, String gmail, CustomerType customerType) {
        super(id, code, name, phoneNumber, gmail);
        this.customerType = customerType;
    }

    public Customer(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "+----+----------------+-----------------+--------------------+-----------------+\n" +
                "| ID | Tên khách hàng |  Số điện thoại  |       Email        | Loại khách hàng |\n" +
                "+----+----------------+-----------------+--------------------+-----------------+\n" +
                String.format("| %-2d | %-14s | %-15s | %-18s | %-15s |\n", super.getId(), super.getName(),
                        super.getPhoneNumber(), super.getGmail(), this.customerType.getName()) +
                "+----+----------------+-----------------+--------------------+-----------------+\n";
    }
}
