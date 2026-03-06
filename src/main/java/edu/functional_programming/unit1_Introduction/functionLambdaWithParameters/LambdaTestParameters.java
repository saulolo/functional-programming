package edu.functional_programming.unit1_Introduction.functionLambdaWithParameters;

public class LambdaTestParameters {

    public static void main(String[] args) {

        // ========== EXPRESIONES LAMBDA CON PARÁMETROS ==========
        FunctionTestParameters op = (numA, numB) -> System.out.println(numA + numB);

        LambdaTestParameters lambdaTestParameters = new LambdaTestParameters();
        lambdaTestParameters.myMethod(op, 2, 6);

        //Pero si quiero una función personalisa por ejemplo para resta:
        lambdaTestParameters.myMethod(((numA, numB) -> System.out.println(numA - numB)), 8, 2);

    }

    public void myMethod(FunctionTestParameters parameter, int numberA, int numberB) {
        parameter.operationPrint(numberA, numberB);
    }
}