package edu.functional_programming.unit1_Introduction.functionLambda;

public class LambdaTest {

    public static void main(String[] args) {

        //Haciendo una instancia de una Interfaz mediante un new
/*        FunctionTest test = new FunctionTest() {
            @Override
            public void greet() {

            }
        };*/

        // ========== EXPRESIONES LAMBDA SIN PARÁMETROS ==========
        //=== Una forma ===
        //Haciendo una instancia de la Interfaz funcional FunctionTest mediante un lambda
        FunctionTest testLambda = () -> System.out.println("Hello Saul desde Lambda");
        testLambda.greet();

        //=== Forma común ===
        //Llamada mediante el métod creado
        LambdaTest object = new LambdaTest();
        object.myMethod(testLambda);

        // ========== EXPRESIONES LAMBDA CON PARÁMETROS ==========


    }

    //Normalmente se hace desde un méthod
    public void myMethod(FunctionTest parameter) {
        parameter.greet();
    }
}
