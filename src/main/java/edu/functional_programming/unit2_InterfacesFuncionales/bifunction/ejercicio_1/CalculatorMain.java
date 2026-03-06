package edu.functional_programming.unit2_InterfacesFuncionales.bifunction.ejercicio_1;

public class CalculatorMain {

    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        String result = calculator.calc(((x, y) -> String.valueOf(x).concat(String.valueOf(y))), 13, 12);
        System.out.println(result);
    }
}
