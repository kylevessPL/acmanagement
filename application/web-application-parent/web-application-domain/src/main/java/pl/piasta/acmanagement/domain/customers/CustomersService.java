package pl.piasta.acmanagement.domain.customers;

import pl.piasta.acmanagement.domain.customers.model.Customer;

import java.util.List;

public interface CustomersService {

    void addCustomer(Customer customer);
    void updateCustomer(Long id, Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
}
