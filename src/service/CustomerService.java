package service;

import repository.CustomerRepository;
import repository.ICustomerRepository;

public class CustomerService implements ICustomerService{
    private static ICustomerRepository iCustomerRepository=new CustomerRepository();

}
