package model;

public class Customer extends People{
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
        return "Customer{" +
                "customerType=" + customerType +
                '}';
    }
}
