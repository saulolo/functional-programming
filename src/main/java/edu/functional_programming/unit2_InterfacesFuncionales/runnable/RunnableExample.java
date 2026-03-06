package edu.functional_programming.unit2_InterfacesFuncionales.runnable;

public class RunnableExample {

    public static void main(String[] args) {

        /*
        * ∫ Runnable
        *💡No Recibe argumentos y no retorna nada, solo ejecuta un procedimiento.
        */
        Runnable runnable = () -> System.out.println("Hola ejecutando una tarea desde runnable");
        runnable.run();

    }
}
