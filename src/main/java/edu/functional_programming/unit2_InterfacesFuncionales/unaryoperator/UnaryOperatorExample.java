package edu.functional_programming.unit2_InterfacesFuncionales.unaryoperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {

        /*
        * ∫ UnaryOperator<T>
        *💡Recibe un argumento de un tipo y retorna el resultado del mismo tipo recibido
        */
        UnaryOperator<String> unaryOperator = s -> s;
        System.out.println(unaryOperator.apply("Hola desde Unary Operator."));

    }
}
