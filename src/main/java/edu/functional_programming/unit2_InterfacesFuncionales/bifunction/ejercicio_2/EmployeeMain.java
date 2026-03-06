package edu.functional_programming.unit2_InterfacesFuncionales.bifunction.ejercicio_2;

import java.util.Arrays;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {


        List<Employee> employeeList = Arrays.asList(
                new Employee("Saul", 2000.0),
                new Employee("Felipe", 10400.0),
                new Employee("Alejandra ", 8350.0)
        );


        Calculator2 calculator2 = new Calculator2();

        List<Double> newSalary =  calculator2.calc2(( salario, increment) ->
                salario + (salario * (increment/100)), employeeList,  16.0);

        for (Double v : newSalary) {
            System.out.println(v);
        }

    }

}
