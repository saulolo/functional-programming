package edu.functional_programming.unit1_Introduction;

/**
 * Se requiere un ejercicio simple que permita utilizar las expresiones lambda creando una intefaz funcional.
 * El ejercicio crea una intefaz funcional llamada MathOperation con un métod abstracto operation. El propósito de esta
 * interfaz es poder realizar operaciones aritméticas con dos parámetros. En este caso, se requiere que sean las operacones
 * de suma y resta.
 */
public class Exercise {

    @FunctionalInterface
    interface MathOperation {
        //Crea un métod abstracto dentro de esta interfaz funcional que se llame "operation"
        //El métod abstracto recibirá dos parámetros de tipo int.
        int operation(int num1, int num2);
    }

    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b; //Crea una expresión lambda que realice una suma.
        MathOperation subtraction = (a, b) -> a - b; //Crea una expresión lambda que realice una resta.

        System.out.println("Addition: " + operate(10, 5, addition)); //Pásale el tercer argumento que le falta a la invocación del método operate.
        System.out.println("Subtraction: " + operate(10, 5, subtraction)); //Pásale el tercer argumento que le falta a la invocación del método operate.
    }

    public static int operate(int a, int b, MathOperation mathOperation) {
        //Implementa el retorno que este métod tendría que tener.
        return mathOperation.operation(a, b);
    }
}