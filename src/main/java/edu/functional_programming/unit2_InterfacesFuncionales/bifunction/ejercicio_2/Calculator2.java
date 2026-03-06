package edu.functional_programming.unit2_InterfacesFuncionales.bifunction.ejercicio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Calculator2 {


    public List<Double>  calc2(BiFunction<Double, Double, Double> biFunction, List<Employee> employeeList, Double increment) {

        List<Double> salaryList = new ArrayList<>();

        for (Employee employee : employeeList) {
            salaryList.add(biFunction.apply(employee.getSalary(), increment));
        }

        return salaryList;
    }

}
