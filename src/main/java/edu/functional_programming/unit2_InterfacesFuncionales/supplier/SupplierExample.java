package edu.functional_programming.unit2_InterfacesFuncionales.supplier;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        /*
        * ∫ Supplier<T>
        *💡No Recibe argumentos pero retorna un resultado
        */
        Supplier<String> supplier = () -> "Hola desde Supplier";
        System.out.println(supplier.get());

    }
}
