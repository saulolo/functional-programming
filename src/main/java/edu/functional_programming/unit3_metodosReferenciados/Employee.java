package edu.functional_programming.unit3_metodosReferenciados;

import lombok.Data;


public class Employee extends Person{

    public Employee(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void greet() {
        System.out.println("Hola soy empleado.");;
    }
}
