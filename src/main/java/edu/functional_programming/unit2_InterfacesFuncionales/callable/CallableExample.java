package edu.functional_programming.unit2_InterfacesFuncionales.callable;

import java.util.concurrent.Callable;

public class CallableExample {

    public static void main(String[] args) {

        /*
        * ∫ Callable<V>
        *💡No Recibe argumentos, pero retorna un resultado y puede lanzar una excepción
        */
        Callable<String> callable = () -> "Estoy ejecutando una tarea...";
        try {
            System.out.println(callable.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
