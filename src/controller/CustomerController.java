package controller;


import model.Customer;
import model.Person;
import service.CustomerService;
import service.ICustomerService;

import java.util.List;

public class CustomerController {
    private static ICustomerService customerService=new CustomerService();

    public static List<Person> displayCustomer() {

        return customerService.displayCustomer();
    }

    public void addCus(Person customer) {
        customerService.addCus(customer);
    }

    public Customer findId(int id) {

        return customerService.findId(id);
    }

    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    public void removeCustomer(int id) {
        customerService.removeCustomer(id);
    }
}
