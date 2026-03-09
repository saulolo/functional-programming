package edu.functional_programming.unit5_optional.ejercicio1.controller;

import edu.functional_programming.unit5_optional.ejercicio1.exception.EmployeeNotFoundException;
import edu.functional_programming.unit5_optional.ejercicio1.model.Employee;
import edu.functional_programming.unit5_optional.ejercicio1.service.interfaces.IEmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeServices employeeServices;

    public Optional<Employee> findEmployeeByEmail(String email) {
        return Optional.of(employeeServices.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundException(email)));
    }
}
