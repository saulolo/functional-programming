package edu.functional_programming.unit4_streams;

import java.util.Arrays;
import java.util.List;

public class OperatorsExample {
    public static void main(String[] args) {

        System.out.println("=== CONVERTIR LISTA O ARRAY A STREAM ===");
        //1. A partir de una lista o un arreglo...
        List<String> names = Arrays.asList("Saul", "Felipe", "Alejandra", "Diego", "leidy", "Pablo", "Alejandra");

        //2. ...convierto dicha lista en un stream para operar con ella
        names.forEach(System.out::println);

        System.out.println("\n=== OPERADORES INTERMEDIOS ===");

        System.out.println("\n== ︎🔍 filter(): Filtra los elementos que cumplen una condición. ==");
        names.stream()
                .filter(name -> name.contains("A") && name.length() > 4)
                .forEach(System.out::println);

        System.out.println("\n== 🌍 map(): Transforma los elementos aplicando una función. ==");
        names.stream()
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("S"))
                .forEach(System.out::println);

        System.out.println("\n== 🗂️ sorted(): Ordena los elementos del stream. ==");
        names.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n== 🔗 reduce(): Combina todos los elementos en un solo valor. ==");
        String reduce = names.stream()
                .reduce("Resultado: ", (s, s2) -> s + " " + s2);
        System.out.println(reduce);

        System.out.println("\n== 📚 toList(): Recoge los elementos en una colección. ==");
        names.stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);

        System.out.println("\n== ≠ distinct(): Elimina los elementos duplicados. ==");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n== 🚧️ limit(): limita el número de elementos procesados. ==");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n== ⏩️ skip(): Omite un número especifico de elementos. ==");
        names.stream()
                .skip(4)
                .forEach(System.out::println);


        System.out.println("\n=== OPERADORES FINALES ===");

        System.out.println("\n== ☑️ anyMatch(): Verifica si algun elemento cumple una condición. ==");
        boolean result = names.stream()
                .anyMatch(s -> s.startsWith("S"));
        System.out.println(result);

        System.out.println("\n== 👌 allMatch(): Verifica si todos los elementos cumplen con una condición. ==");
        boolean result2 = names.stream()
                .allMatch(s -> s.startsWith("F"));
        System.out.println(result2);

        System.out.println("\n== 🚫 noneMatch(): Verifica si ningun elemento cumple una condición. ==");
        boolean result3 = names.stream()
                .noneMatch(s -> s.startsWith("J"));
        System.out.println(result3);

        System.out.println("\n== 🖨️ foreach(): Aplica una acción a cada elemento (No sol imprime). ==");
        names.forEach(System.out::println);

    }

}
