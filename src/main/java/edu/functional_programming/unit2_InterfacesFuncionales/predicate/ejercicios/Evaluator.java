package edu.functional_programming.unit2_InterfacesFuncionales.predicate.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Evaluator {

    public List<Student> toValue(List<Student> employeeList, Predicate<Student> eval) {

        List<Student> newEmployees = new ArrayList<>();

        for (Student employee : employeeList) {
            if (eval.test(employee)) {
                newEmployees.add(employee);
            }
        }

        return newEmployees;
    }

    public List<Student> toOppositeValue(List<Student> employeeList, Predicate<Student> eval) {

        List<Student> newEmployees = new ArrayList<>();

        for (Student employee : employeeList) {
            if (eval.negate().test(employee)) {
                newEmployees.add(employee);
            }
        }

        return newEmployees;
    }
}
