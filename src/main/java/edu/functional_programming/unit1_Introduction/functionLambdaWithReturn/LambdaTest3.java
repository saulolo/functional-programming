package edu.functional_programming.unit1_Introduction.functionLambdaWithReturn;

public class LambdaTest3 {

    public static void main(String[] args) {

        // ========== AMBIGUEDAD DE TIPOS EN LOS PARAMETROS ==========
        //SI tenemos sobrecarga de metodos, nos toca poner que tipo de variable es para diferenciarlos
        engine((int num1, int num2) -> num1 + num2);
        engine((Calculator) (num1, num2) -> num1 / num2);

        // ó
        CalculatorLong call = (num1, num2) -> num1 - num2;
        engine(call);
        engine((long num1, long num2) -> num1 * num2);

    }

    public static void engine (Calculator calculator) {
        int number1 = 4;
        int number2 = 2;
        int result = calculator.operation(number1, number2);
        System.out.println("==> " + result);
    }

    public static void engine (CalculatorLong calculatorLong){
        long number1 = 6;
        long number2 = 3;
        long result = calculatorLong.operation(number1, number2);
        System.out.println("==> " + result);
    }

}
