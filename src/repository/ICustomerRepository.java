package repository;

import model.Customer;
import model.Person;

import java.util.List;

public interface ICustomerRepository {
    List<Person> displayCustomer();

    void addCus(Person customer);

    Customer findId(int id);

    void updateCustomer(Customer customer);

    void removeCustomer(int id);

}
