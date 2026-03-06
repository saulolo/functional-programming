package edu.functional_programming.unit2_InterfacesFuncionales.biconsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        /*
        * ∫ BiConsumer<T,U>
        *💡Recibe dos argumentos  y no retorna nada
        */
        BiConsumer<String, Integer> biConsumer = (x, y) -> System.out.println(x + y + " años");
        biConsumer.accept("Se llama Saul y tiene ", 40);

    }
}
