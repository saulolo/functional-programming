package edu.functional_programming.unit2_InterfacesFuncionales.consumer.ejercicios;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUniversity {

    String name;
    double rating;


    public StudentUniversity(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }
}
