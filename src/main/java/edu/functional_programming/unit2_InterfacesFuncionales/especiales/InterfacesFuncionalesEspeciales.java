package edu.functional_programming.unit2_InterfacesFuncionales.especiales;

import java.util.function.*;

public class InterfacesFuncionalesEspeciales {

    public static void main(String[] args) {

        System.out.println("=== INTERFACES FUNCIONALES ESPECIALES ===");
        System.out.println("Para tipos primitivos");

        //IntFunction<R>, LongFunction<R>, DoubleFunction<R>
        /*
         * ∫ IntFunction<T>
         * 💡Reciben un primitivo y devuelven un objeto
         */
        IntFunction<String> intToString = Integer::toString;
        System.out.println(intToString.apply(123)); // "123"


        // IntConsumer, LongConsumer, DoubleConsumer
        /*
         * ∫ IntConsumer<T>
         * 💡Reciben un primitivo y no devuelven nada.
         */
        IntConsumer intPrinter = System.out::println;
        intPrinter.accept(42);


        //IntSupplier, LongSupplier, DoubleSupplier
        /*
         * ∫ IntSupplier<>
         * 💡No reciben argumentos y devuelven un primitivo.
         */
        IntSupplier intSupplier = () -> 99;
        System.out.println(intSupplier.getAsInt());


        //IntPredicate, LongPredicate, DoublePredicate
        /*
         * ∫ IntPredicate<T,R>
         * 💡Reciben un primitivo y devuelven booleano.
         */
        IntPredicate esPar = x -> x % 2 == 0;
        System.out.println(esPar.test(8)); // true


        //IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
        /*
         * ∫ IntUnaryOperator<T,R>
         * 💡Reciben y devuelven el mismo tipo primitivo.
         */
        IntUnaryOperator doblar = x -> x * 2;
        System.out.println(doblar.applyAsInt(10)); // 20


        //IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator
        /*
         * ∫ IntUnaryOperator<T,R>
         * 💡Reciben dos y devuelven un primitivo del mismo tipo.
         */
        IntBinaryOperator sumador = (a, b) -> a + b;
        System.out.println(sumador.applyAsInt(3, 4)); // 7



        System.out.println("=== OTRAS ESPECIALIDADES ÚTILES ===");

        // ToIntFunction<T>, ToLongFunction<T>, ToDoubleFunction<T>
        /*
         * ∫ ToIntFunction<T,R>
         * 💡Reciben objeto y devuelven primitivo
         */
        ToIntFunction<String> stringLength = String::length;
        System.out.println(stringLength.applyAsInt("Java")); // 4


        //ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T>
        /*
         * ∫ ToIntFunction<T,R>
         * 💡Reciben (objeto, primitivo) y no devuelven nada.
         */
        ObjIntConsumer<String> printTimes = (s, n) -> System.out.println(s.repeat(n));
        printTimes.accept("Hi! ", 3); // "Hi! Hi! Hi! "

    }
}
