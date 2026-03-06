package edu.functional_programming.unit2_InterfacesFuncionales.bifunction.ejercicio_1;

import java.util.function.BiFunction;

public class Calculator {

    public String calc(BiFunction<Integer, Integer, String> biFunction, Integer num1, Integer num2) {
        return biFunction.apply(num1, num2);
    }

}
