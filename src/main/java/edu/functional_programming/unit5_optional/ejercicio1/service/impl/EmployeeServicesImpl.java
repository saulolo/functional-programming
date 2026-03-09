package edu.functional_programming.unit5_optional.ejercicio1.service.impl;

import edu.functional_programming.unit5_optional.ejercicio1.model.Employee;
import edu.functional_programming.unit5_optional.ejercicio1.service.interfaces.IEmployeeServices;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements IEmployeeServices {

    @Override
    public List<Employee> getEmployeesFromDB() {
        Employee emp1 = new Employee(1L, "Saul Echeverri", 200_000, Employee.Gender.MAN, 34, "saulolo@example.com");
        Employee emp2 = new Employee(2L, "Felipe Vasquez", 99_000, Employee.Gender.MAN, 42, "vasquez@example.com");
        Employee emp3 = new Employee(3L, "Alejandra Arenas", 230_000, Employee.Gender.WOMAN, 39, "arenas@example.com");
        Employee emp4 = new Employee(4L, "Leidy Zapata", 520_000, Employee.Gender.WOMAN, 48, "zapata@example.com");
        Employee emp5 = new Employee(5L, "Diego Martinez", 50_000, Employee.Gender.MAN, 40, "martinez@example.com");
        Employee emp6 = new Employee(6L, "Pablo Lopez", 300_000, Employee.Gender.MAN, 42, "lopez@example.com");

        return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
    }

    @Override
    public Optional<Employee> findEmployeeByEmail(String email) {
        return getEmployeesFromDB().stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst();
    }
}
