package edu.functional_programming.unit2_InterfacesFuncionales.predicate;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        /*
         * ∫ Predicate<T>
         * 💡Recibe un argumento de un tipo y retorna un boleano.
         */
        Predicate<Integer> predicate = x -> x > 3;
        System.out.println(predicate.test(4));

    }


}
