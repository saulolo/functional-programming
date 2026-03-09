package edu.functional_programming.unit5_optional.ejercicio1.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super("No se encontró el empleado solicitado con el término: " + message);
    }
}
