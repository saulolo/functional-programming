package edu.functional_programming.unit2_InterfacesFuncionales.function;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        /*
         * ∫ Function<T, R>
         * 💡Recibe un argumento de un tipo y retorna otro argumentro de otro tipo
         */

        Function<Integer, String> converter = number -> Integer.toString(number);

        //apply recibe un argumento dado y lo convierte al string en este caso.
        System.out.println("Conversión => " + converter.apply(5));
        System.out.println("Conversión => " + converter.apply(60).length());

    }
}
