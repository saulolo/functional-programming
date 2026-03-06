package edu.functional_programming.unit4_streams.ejercicio1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee implements Comparable{

    Long id;
    String name;
    double income;
    Gender gender;
    Integer age;


    public static enum Gender {
        MAN, WOMAN
    }

    public boolean isMan() {
        return this.gender == Gender.MAN;
    }

    public boolean isWoman() {
        return this.gender == Gender.WOMAN;
    }

    public static List<Employee> employees() {
        Employee emp1 = new Employee(1L, "Saul Echeverri", 200_000, Gender.MAN, 34);
        Employee emp2 = new Employee(2L, "Felipe Vasquez", 99_000, Gender.MAN, 42);
        Employee emp3 = new Employee(3L, "Alejandra Arenas", 230_000, Gender.WOMAN, 39);
        Employee emp4 = new Employee(4L, "Leidy Zapata", 520_000, Gender.WOMAN, 48);
        Employee emp5 = new Employee(5L, "Diego Martinez", 50_000, Gender.MAN, 40);
        Employee emp6 = new Employee(6L, "Pablo Lopez", 300_000, Gender.MAN, 42);

        return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Employee)o).getName());
    }

    @Override
    public String toString() {
        return String.format(
                "%-3d | %-18s | %-7d | %-10.2f | %-5s",
                id, name, age, income, gender
        );
    }

}
