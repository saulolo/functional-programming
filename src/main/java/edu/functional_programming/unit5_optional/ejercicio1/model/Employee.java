package edu.functional_programming.unit5_optional.ejercicio1.model;

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
    String email;


    public static enum Gender {
        MAN, WOMAN
    }

    public boolean isMan() {
        return this.gender == Gender.MAN;
    }

    public boolean isWoman() {
        return this.gender == Gender.WOMAN;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Employee)o).getName());
    }

    @Override
    public String toString() {
        return String.format(
                "%-3d | %-18s | %-7d | %-10.2f | %-5s | %-4s",
                id, name, age, income, gender, email
        );
    }

}
