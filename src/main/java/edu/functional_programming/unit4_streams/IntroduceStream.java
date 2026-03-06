package edu.functional_programming.unit4_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntroduceStream {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Stream<Integer> numberStreams = numbers.stream();
        int sum = numberStreams
                .filter(x -> x % 2 == 1) //Filtra por los números impares
                .map(x -> x * x)  //Multiplica al nuevo stream por si mismo
                .reduce(0, Integer::sum); //Suma los numeros del nuevo stream

        System.out.println("La sumatoria de los números impares es: " + sum);

    }
}
