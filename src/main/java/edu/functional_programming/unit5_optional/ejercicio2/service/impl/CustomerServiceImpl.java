package edu.functional_programming.unit5_optional.ejercicio2.service.impl;

import edu.functional_programming.unit5_optional.ejercicio2.model.Customer;
import edu.functional_programming.unit5_optional.ejercicio2.service.interfaces.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    public static List<Customer> getCustomerFromDB() {

        return Arrays.asList(
                new Customer(1L, "Saul", "Echeverri", null, "3112233444"),
                new Customer(2L, "Felipe", "Vasquez", "Calle Poblado", "3114455446"),
                new Customer(3L, "Alejandra", "Arenas", "Calle La 80", "3332243544"),
                new Customer(4L, "Leidy", "Zapata", "Calle Americas", "3817233464"),
                new Customer(5L, "Diego", "Martinez", "Calle Palmas", "3918233444"),
                new Customer(6L, "Sandra", "Uribe", null, "3122233342"),
                new Customer(7L, "Alvaro", "Escobar", "Calle Consumo", "3122435464"),
                new Customer(8L, "Oswaldo", "Garcia", "Calle Belen", "3132833474"),
                new Customer(9L, "Eliza", "Perez", null, "3132485404"),
                new Customer(10L, "Pablo", "Lopez", "Calle Madrid", "3132293404")
        );

    }

    @Override
    public Optional<Customer> getCustomer(List<Customer> customers, Long number) {
        return customers.stream()
                .filter(cli -> cli.getId().equals(number))
                .findFirst();
    }

    @Override
    public Optional<String> getAddress(Optional<Customer> customer) {
        return customer
                .map(Customer::getAddress);
    }
}
