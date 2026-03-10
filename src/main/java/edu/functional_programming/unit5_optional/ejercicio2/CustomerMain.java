package edu.functional_programming.unit5_optional.ejercicio2;

import edu.functional_programming.unit5_optional.ejercicio2.model.Customer;
import edu.functional_programming.unit5_optional.ejercicio2.service.impl.CustomerServiceImpl;
import edu.functional_programming.unit5_optional.ejercicio2.service.interfaces.ICustomerService;

import java.util.Optional;
import java.util.Scanner;

public class CustomerMain {

    public static void main(String[] args) {

        ICustomerService customerService = new CustomerServiceImpl();

        System.out.println("=== BIENVENIDOS A ENVIOS SAULOLO'S ===");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa el ID del cliente a enviar el paquete: ");
        Long number = scanner.nextLong();

        Optional<Customer> customer = customerService.getCustomer(CustomerServiceImpl.getCustomerFromDB(), number);
        if (customer.isPresent()) {
            Optional<String> addressCustomer = customerService.getAddress(customer);
            if (addressCustomer.isPresent()) {
                System.out.println("La dirección del cliente es: " + addressCustomer.get());
            } else {
                System.out.println("Este cliente no tiene dirección.");
            }
        } else {
            System.out.println("El cliente en cuestión no existe.");
        }

    }
}
