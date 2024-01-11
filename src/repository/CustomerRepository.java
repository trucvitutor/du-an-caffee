package repository;

import common.FileService;
import model.Customer;
import model.Person;


import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String FILE_CUSTOMER = "src/data/Customer.txt";

    @Override
    public List<Person> displayCustomer() {
        FileService<Person> fileService = new FileService<>();
        List<Person> customers = fileService.readFile(FILE_CUSTOMER);
        return customers;
    }

    @Override
    public void addCus(Person customer) {
        FileService<Person> fileService = new FileService<>();
        List<Person> customers = fileService.readFile(FILE_CUSTOMER);
        customers.add(customer);
        fileService.writeFile(FILE_CUSTOMER, customers);
    }

    @Override
    public Customer findId(int id) {
        FileService<Person> fileService = new FileService<>();
        List<Person> customers = fileService.readFile(FILE_CUSTOMER);
        for (Person a : customers) {
            if (a.getId() == id) {
                return (Customer) a;
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
        FileService<Person> fileService = new FileService<>();
        List<Person> customers = fileService.readFile(FILE_CUSTOMER);
        for (Person a : customers) {
            a.setCode(customer.getCode());
            a.setName(customer.getName());
            a.setPhoneNumber(customer.getPhoneNumber());
            a.setGmail(customer.getGmail());
            ((Customer) a).setCustomerType(customer.getCustomerType());
            break;

        }
        fileService.writeFile(FILE_CUSTOMER, customers);
    }

    @Override
    public void removeCustomer(int id) {
        FileService<Person> fileService = new FileService<>();
        List<Person> customers = fileService.readFile(FILE_CUSTOMER);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(customers.get(i));
            }
        }
        fileService.writeFile(FILE_CUSTOMER, customers);
    }
}
