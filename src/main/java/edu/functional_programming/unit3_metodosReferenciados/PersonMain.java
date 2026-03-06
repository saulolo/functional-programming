package edu.functional_programming.unit3_metodosReferenciados;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonMain {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Saul", 40, "saulolo@example.com"),
                new Person("Felipe", 40, "vasquez@example.com"),
                new Person("Alejandra", 39, "arenas@example.com"),
                new Person("Leidy", 39, "zapata@example.com"),
                new Person("Diego", 41, "martinez@example.com")
        );


        System.out.println("Personas sin ordenar");
        //people.forEach(p -> System.out.println(p)) ;
        people.forEach(System.out::println) ;

        System.out.println("\nPersonas ordenadas");
        //people.sort(((person1, person2) -> person1.getAge().compareTo(person2.getAge()))); ==> Comparación desde aqui
        //people.sort(((person1, person2) -> Person.compareToAge(person1, person2))); ==> Comparación llamando al metodo estatico creado
        people.sort((Person::compareToAge)); //==> Comparación por Referencia llamando al metodo estatico creado
        people.forEach(System.out::println) ;

    }
}
