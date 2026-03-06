package edu.functional_programming.unit2_InterfacesFuncionales.bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {

    public static void main(String[] args) {

        /*
         * ∫ BiPredicate<T>
         * 💡Recibe dos argumento y retorna un boleano.
         */
        BiPredicate<Integer, Integer>  biPredicate = (x, y)-> (x  > y);
        System.out.println(biPredicate.test(4, 5));

    }

}
