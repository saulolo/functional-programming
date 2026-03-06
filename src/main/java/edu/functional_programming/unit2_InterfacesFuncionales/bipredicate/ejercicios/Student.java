package edu.functional_programming.unit2_InterfacesFuncionales.bipredicate.ejercicios;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    String name;
    int age;
    double salary;
    String department;

    public Student(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
}
