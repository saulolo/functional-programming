package edu.functional_programming.unit2_InterfacesFuncionales.bifunction;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {

        /*
         * ∫ BiFunction<T, U, R>
         * 💡Recibe dos argumento y retorna un resultado.
         */

        BiFunction<String, String, String> concat = (x, y) -> x.concat(y);
        //BiFunction<String, String, String> concat = String::concat;

        System.out.println(concat.apply("Hola ","Mundo."));

    }
}
