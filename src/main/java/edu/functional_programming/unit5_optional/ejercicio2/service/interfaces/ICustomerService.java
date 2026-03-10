package edu.functional_programming.unit5_optional.ejercicio2.service.interfaces;

import edu.functional_programming.unit5_optional.ejercicio2.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<Customer> getCustomer(List<Customer> customers, Long number);

    Optional<String> getAddress(Optional<Customer> customer);

}
