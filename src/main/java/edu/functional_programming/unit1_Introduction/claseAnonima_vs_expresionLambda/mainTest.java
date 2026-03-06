package edu.functional_programming.unit1_Introduction.claseAnonima_vs_expresionLambda;

public class mainTest {

    public static void main(String[] args) {

        // ========== RESULETO CON CLASES ANÓNIMAS ==========
        Operador operadorAnonimo = new Operador() {
            @Override
            public int operar(int num1, int num2) {
                return num1 + num2;
            }
        };

        System.out.println("Resultado con Clases Anónimas => " + operadorAnonimo.operar(4, 2));


        // ========== RESULETO CON EXPRESIONES LAMBDAS ==========
        //Tambien puedo usar referencias a metodos asi:
        //Operador operadorLambda = Integer::sum
        Operador operadorLambda = (num1, num2) -> num1 + num2;;

        System.out.println("Resultado con Expresiones Lambda => " + operadorLambda.operar(4, 1));

    }
}
