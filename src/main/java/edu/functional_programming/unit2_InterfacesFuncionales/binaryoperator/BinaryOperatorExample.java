package edu.functional_programming.unit2_InterfacesFuncionales.binaryoperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {

        /*
        * ∫ BinaryOperator<T>
        *💡Recibe dos argumento de un mismo tipo y retorna el resultado del mismo tipo recibido
        */
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(2, 4));

    }
}
