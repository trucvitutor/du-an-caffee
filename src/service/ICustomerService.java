package service;

import model.Customer;
import model.Person;

import java.util.List;

public interface ICustomerService {
    List<Person> displayCustomer();

    void addCus(Person customer);

    Customer findId(int id);

    void updateCustomer(Customer customer);

    void removeCustomer(int id);

}
