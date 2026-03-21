package edu.functional_programming.unit1_Introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestExpresionesLambdaLaTecAva {

    public static void main(String[] args) {

        System.out.println("=== FORMA TRADICIONAL (CON BUCLES) ===");
        for (Integer number : Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10)) {
            System.out.println(number + " ");
        }

        System.out.println("\n=== CON EXPRESIONES LAMBDA ===");
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10).forEach(System.out::println);


        System.out.println("\n=== N + 1 CON EXPRESIONES LAMBDA ===");
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10).forEach(num -> System.out.println(num + (num + 1)));


        System.out.println("\n=== MAYORES A 5 - CON BUCLES ===");
        //A partir de una lista comprobemos los números mayores a 5 y los agregamos a otra lista.
        List<Integer> numbers = Arrays.asList(4, 21, 3, 4, 1, 2, 7, 9, 10);
        ArrayList<Integer> minorList = new ArrayList<>();

        for (Integer num : numbers) {
            if (num > 5) {
                minorList.add(num);
            }
        }

        //Mostrando la lista
        for (Integer i : minorList) {
            System.out.println(i);
        }

        System.out.println("\n=== MAYORES A 5 - CON EXPRESIONES LAMBDA ===");
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> mayorNumbers = numberList.stream()
                .filter(n -> n > 5)
                .toList(); //Creo la nueva lista con los números filtrados

        mayorNumbers.forEach(System.out::println);


    }
}
