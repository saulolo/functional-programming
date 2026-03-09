package edu.functional_programming.unit5_optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        System.out.println("=== Ejemplo 1 ===");
        //ofNullable transforma un objeto null en uno vacio.
        Optional<String> stringNull = Optional.ofNullable(null);
        if (stringNull.isEmpty()) System.out.println("El valor es vacio.");
        if (stringNull == null) System.out.println("El valor es vacio.");

        System.out.println("=== Ejemplo 2 ===");
        //of siempre tiene un valor y no puede recibir un null.
        Optional<String> text = Optional.of("Si tiene valor.");
        if (text.isEmpty()) System.out.println("El valor es vacio.");
        else  System.out.println("Tiene un valor.");

        System.out.println("=== Ejemplo 3 ===");
        //empty genera un objeto pero vacio.
        Optional<String> textEmpty = Optional.empty();
        if (textEmpty.isEmpty()) System.out.println("El valor es vacio.");
        else  System.out.println("Tiene un valor.");

    }
}
