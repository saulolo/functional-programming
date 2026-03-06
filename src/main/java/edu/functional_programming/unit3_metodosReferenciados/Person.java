package edu.functional_programming.unit3_metodosReferenciados;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    String name;
    Integer age;
    String email;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static int compareToAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }

    public void greet() {
        System.out.println("Hola mi nombre es: " + name);
    }

}
