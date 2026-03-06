package edu.functional_programming.unit4_streams.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AutomobileMain {

    public static void main(String[] args) {

        List<Automobile> listaAutos = Arrays.asList(
                new Automobile("Volkswagen", "Amarok", 25000),
                new Automobile("Volkswagen", "Taos", 32000),
                new Automobile("Chevrolet", "Onix", 22000),
                new Automobile("Chevrolet", "Tracker", 30000),
                new Automobile("Fiat", "Cronos", 21000),
                new Automobile("Fiat", "Pulse", 24000),
                new Automobile("Toyota", "Corolla", 28000),
                new Automobile("Toyota", "Yaris", 23000),
                new Automobile("Renault", "Stepway", 20000),
                new Automobile("Renault", "Duster", 27000),
                new Automobile("Nissan", "Versa", 25000)
        );

        // 1. Ordenar por precio de menor a mayor mediante sort
        System.out.println("Ordenado por precio de menor a mayor: ");
        List<Automobile> ordenPrecio = new ArrayList<>(listaAutos);
        ordenPrecio.sort(Comparator.comparing(Automobile::getCosto));
        ordenPrecio.forEach(System.out::println);
        System.out.println("--------------------------");

        // 2. Ordenar por marca y luego por precio usando sorted()
        System.out.println("Ordenado por marca y luego por precio usando sorted()");
        listaAutos.stream()
                .sorted(Comparator
                        .comparing(Automobile::getMarca)
                        .thenComparing(Automobile::getCosto))
                .forEach(System.out::println);
        System.out.println("--------------------------");

        // 3. Autos cuyo precio no supere los 23000
        System.out.println("Filtrado autos más baratos que 23000");
        listaAutos.stream()
                .filter(auto->auto.getCosto()<=23000)
                .forEach(System.out::println);
        System.out.println("--------------------------");

        // 4. Autos de marca Chevrolet o Volkswagen
        System.out.println("Filtrado autos Chevrolet y Volkswagen");
        listaAutos.stream()
                .filter(auto->auto.getMarca().equals("Chevrolet") || auto.getMarca().equals("Volkswagen"))
                .forEach(System.out::println);
        System.out.println("--------------------------");

        // 5. Autos cuyo modelo contiene al menos una “a”
        System.out.println("Filtrado autos cuyo modelo tiene una a");
        listaAutos.stream()
                .filter(auto->auto.getModelo().toLowerCase().contains("a"))
                .forEach(System.out::println);

    }
}
