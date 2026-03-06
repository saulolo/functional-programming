package edu.functional_programming.unit1_Introduction.functionLambdaWithReturn;

public class WithMethodReturn {

    public static void main(String[] args) {

        // ========== EXPRESIÓN LAMBDA COMO RETORNO DE MÉTODOS ==========
        System.out.println(create().operation(10, 5));

    }

    public static CalculatorLong create() {
        return (num1, num2) -> (num1 / num2);
    }


}
