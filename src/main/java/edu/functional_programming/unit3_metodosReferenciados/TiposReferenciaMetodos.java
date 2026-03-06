package edu.functional_programming.unit3_metodosReferenciados;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TiposReferenciaMetodos {

    public static void main(String[] args) {

        System.out.println("=== 1. Referencia aun método estatico ===");
        Function<Integer, String> convertTo = String::valueOf;
        String result = convertTo.apply(4);
        System.out.println(result);

        System.out.println("=== 2. Referencia aun método de instancia de un objeto ===");
        Person person = new Person();
        person.setName("Saul");

        Runnable runnable = person::greet;
        runnable.run();

        System.out.println("=== 3. Referencia aun constructor ===");
        BiFunction<String, Integer, Person> createPersona = Person::new;
        System.out.println(createPersona.apply("Saul", 13));

        System.out.println("=== 4. Referencia a un método de una isntancia de un objeto arbitrario ===");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Saul", 41));
        people.add(new Manager("Hernando", 60));
        people.add(new Manager("Mavilia", 65));
        people.add(new Person("Vanessa", 34));

        people.forEach(Person::greet);

    }
}
