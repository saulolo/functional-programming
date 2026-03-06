package edu.functional_programming.unit2_InterfacesFuncionales.comparator;

import java.util.Comparator;

public class ComparatorExample {

    public static void main(String[] args) {

        /*
        * ∫ Comparator<T>
        *💡Recibe un argumento el cual va a ser comparado por el mismo
         */
        Comparator<Integer> compareTo = Comparator.comparing(x -> x);
        System.out.println(compareTo.compare(4, 7));

    }
}
