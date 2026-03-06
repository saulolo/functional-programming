package edu.functional_programming.unit2_InterfacesFuncionales.predicate.ejercicios;

import java.util.Arrays;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {


        List<Student> employeeList = Arrays.asList(
                new Student("Saul", 40, 2800, "Antioquia"),
                new Student("Felipe", 39, 1800, "Cundinamarca"),
                new Student("Alejandra", 41, 700, "Arauca"),
                new Student("Alvaro", 65, 250, "Valle")
        );

        Evaluator evaluator = new Evaluator();

        System.out.println("Empleados con salarios mayores a $ 1000.");
        List<Student> empHighSalaries = evaluator
                .toValue(employeeList, employee -> employee.getSalary() > 1000);

        for (Student empHighSalary : empHighSalaries) {
            System.out.println("Nombre empleado salario alto: " + empHighSalary.getName());
        }


        List<Student> empIniiaS = evaluator
                .toValue(employeeList, employee -> employee.getName().startsWith("S"));


        System.out.println("Empleados cuyp nombre inician con la letra s.");
        for (Student employee : empIniiaS) {
            System.out.println("Nombre empleado: " + employee.getName());
        }

        System.out.println("Empleados salarios menores.");
        List<Student> olderEmployees = evaluator
                .toOppositeValue(employeeList, employee -> employee.getSalary() > 1000);

        for (Student empHighSalary : olderEmployees) {
            System.out.println("Nombre empleado salario bajo: " + empHighSalary.getName());
        }
    }

}
