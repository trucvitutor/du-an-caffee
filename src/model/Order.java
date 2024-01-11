package model;

import java.util.List;

public class Order {
    private int id;
    private String code;
    private Customer customer;
    private int totalPay;
    private Staff staff;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order(int id, String code, Customer customer, int totalPay, Staff staff, List<Product> products) {
        this.id = id;
        this.code = code;
        this.customer = customer;
        this.totalPay = totalPay;
        this.staff = staff;
        this.products = products;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", customer=" + customer +
                ", totalPay=" + totalPay +
                ", staff=" + staff +
                ", products=" + products +
                '}';
    }
}
