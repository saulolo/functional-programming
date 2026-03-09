package edu.functional_programming.unit5_optional.ejercicio1.service.interfaces;

import edu.functional_programming.unit5_optional.ejercicio1.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeServices {

    List<Employee> getEmployeesFromDB();

    Optional<Employee> findEmployeeByEmail(String email);
}
