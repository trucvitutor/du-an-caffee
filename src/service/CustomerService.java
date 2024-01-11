package service;

import model.Customer;
import model.Person;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private static ICustomerRepository iCustomerRepository=new CustomerRepository();

    @Override
    public List<Person> displayCustomer() {
        return iCustomerRepository.displayCustomer();
    }

    @Override
    public void addCus(Person customer) {
        iCustomerRepository.addCus(customer);
    }

    @Override
    public Customer findId(int id) {

        return  iCustomerRepository.findId(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public void removeCustomer(int id) {
        iCustomerRepository.removeCustomer(id);
    }
}
