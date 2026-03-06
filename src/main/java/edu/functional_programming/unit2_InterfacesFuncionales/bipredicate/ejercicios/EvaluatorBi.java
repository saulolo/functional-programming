package edu.functional_programming.unit2_InterfacesFuncionales.bipredicate.ejercicios;

import edu.functional_programming.unit2_InterfacesFuncionales.predicate.ejercicios.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class EvaluatorBi {

    public List<Student> toValue(List<Student> employeeList, BiPredicate<Integer, String> eval) {

        List<Student> studentList = new ArrayList<>();

        for (Student student : employeeList) {
            if (eval.test(student.getAge(), student.getDepartment())) {
                studentList.add(student);
            }
        }

        return studentList;
    }

}
