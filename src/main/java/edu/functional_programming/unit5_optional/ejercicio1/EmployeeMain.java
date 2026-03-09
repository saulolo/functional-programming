package edu.functional_programming.unit5_optional.ejercicio1;

import edu.functional_programming.unit5_optional.ejercicio1.controller.EmployeeController;
import edu.functional_programming.unit5_optional.ejercicio1.exception.EmployeeNotFoundException;
import edu.functional_programming.unit5_optional.ejercicio1.model.Employee;
import edu.functional_programming.unit5_optional.ejercicio1.service.impl.EmployeeServicesImpl;
import edu.functional_programming.unit5_optional.ejercicio1.service.interfaces.IEmployeeServices;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
public class EmployeeMain {


    public static void main(String[] args) {

        IEmployeeServices employeeServices = new EmployeeServicesImpl();
        EmployeeController employeeController = new EmployeeController(employeeServices);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el email del empleado: ");
        String email = scanner.nextLine();

        try {
            Optional<Employee> employee = employeeController.findEmployeeByEmail(email);
            System.out.println("\nEmpleado encontrado:");
            System.out.println(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("\n❌ " + e.getMessage());
        }

    }
}
