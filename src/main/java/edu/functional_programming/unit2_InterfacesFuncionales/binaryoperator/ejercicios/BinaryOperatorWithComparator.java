package edu.functional_programming.unit2_InterfacesFuncionales.binaryoperator.ejercicios;

import java.util.function.BinaryOperator;

public class BinaryOperatorWithComparator {

    public static void main(String[] args) {

        //Ejercicio
        BinaryOperator<Integer> compareTo = BinaryOperator.maxBy(Integer::compareTo);
        System.out.println(compareTo.apply(4, 7));


    }
}
