package edu.functional_programming.unit2_InterfacesFuncionales.consumer;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        /*
        * ∫ Consumer<T>
        * 💡Recibe un valor y no retorna nada
        * */
        //Consumer<String> consumer = x -> System.out.println( x);
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hola y soy un consumer");
    }
}
