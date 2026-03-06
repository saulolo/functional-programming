package edu.functional_programming.unit4_streams.crearStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamExample {

    public static void main(String[] args) {

        System.out.println("=== 1. CREAR STREAM A PARTIR DE UN VALOR ===");
        Stream<String> stream1 = Stream.of("Curso de Programación Funcional");
        stream1.forEach(System.out::println);

        System.out.println("\n=== 2. CREAR STREAM A PARTIR DE VARIOS VALORES ===");
        Stream<String> stream2 = Stream.of("Java", "Python", "C++", "React");
        stream2.forEach(System.out::println);

        System.out.println("\n=== 3. CREAR STREAM A PARTIR DE ARREGLOD ===");
        String[] array = {"Java", "Python", "JavaScript", "SQL"};
        Stream<String> stream3 = Stream.of(array);
        stream3.forEach(System.out::println);

        System.out.println("\n=== 4. CREAR STREAM A PARTIR DE UN BUILDER ===");
        Stream<Student> stream4 = Stream.<Student>builder()
                .add(new Student("01", 20, 1.70, 3.2))
                .add(new Student("02", 30, 1.80, 4.2))
                .add(new Student("03", 40, 1.73, 4.8))
                .build();
        stream4.forEach(student -> System.out.println(student.getId()));

        System.out.println("\n=== 5. CREAR STREAM A PARTIR DE UN RANGOS DE NÚMEROS (como ejemplo) ===");
        IntStream rangeNumbers = IntStream.rangeClosed(1, 20);
        rangeNumbers.forEach(System.out::println);

        System.out.println("\n=== 6. CREAR STREAM A PARTIR DE FUNCIONES (ITERATE) ===");
        System.out.println("== Example 1 ==");
        Stream<Long> firstTen = Stream.iterate(1L, x -> x + 1)
                .limit(10);
        firstTen.forEach(System.out::println);

        System.out.println("== Example 2 ==");
        Stream.iterate(1L, x -> x + 1)
                .filter(n -> n % 2 == 0)
                .limit(20)
                .forEach(System.out::println);

        System.out.println("== Example 3 ==");
        Stream.iterate(1L, x -> x + 1)
                .filter(n -> n % 2 == 0)
                .skip(100) //a partir de 200
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n=== 7. CREAR STREAM A PARTIR DE FUNCIONES (GENERATE) ===");
        System.out.println("== Example 1 ==");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("== Example 2 ==");
        new Random().ints()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n=== 8. CREAR STREAM A PARTIR DE COLECCIONES ===");
        System.out.println("== Example 1 ==");
        IntStream numStream = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7});
        numStream.forEach(System.out::println);

        System.out.println("== Example 2 ==");
        Stream<String> stringStream = Arrays.stream(new String[]{"Saul", "Felipe", "Alejandra", "Leidy"});
        stringStream.forEach(System.out::println);

        System.out.println("== Example 3 ==");
        Set<String> names = new HashSet<>();
        names.add("Saul");
        names.add("Felipe");
        names.add("Alejandra");
        names.add("Diego");

        Stream<String> streamNames = names.stream();
        streamNames.forEach(System.out::println);

        System.out.println("== Example 4 ==");
        List<String> languages = List.of("Java", "Typescript", "Python", "C#");
        Stream<String> languagesStream = languages.stream();
        languagesStream.forEach(System.out::println);

        System.out.println("== Example 5 ==");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", 37, 1.67, 3.1));
        studentList.add(new Student("2", 51, 1.68, 4.1));
        studentList.add(new Student("3", 21, 1.30, 3.7));
        studentList.add(new Student("4", 35, 1.33, 3.7));

        Stream<Student> studentStream = studentList.parallelStream();
        studentStream.forEach(student -> System.out.println(student.getId()));

        System.out.println("\n=== 9. CREAR STREAM A PARTIR DE STRINGS ===");
        System.out.println("== Example 1 ==");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa una cadena de caracteres: ");
        String text = scanner.nextLine();
        IntStream streamChars = text.chars();
        streamChars
                .filter(value -> !Character.isDigit((char) value) && !Character.isWhitespace((char) value))
                .forEach(System.out::println);

        System.out.println("== Example 2 ==");
        String str = "HTML, CSS, JavaScript, React, Angular";
        Pattern.compile(", ")
                .splitAsStream(str)
                .forEach(System.out::println);

        System.out.println("\n=== 10. CREAR STREAM A PARTIR DE ARCHIVOS ===");
        System.out.println("== Example 1 ==");
        String url = "src\\main\\java\\edu\\functional_programming\\unit4_streams\\crearStream\\Parrafo.txt";
        Path path = Paths.get(url);

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(linea -> {
                        System.out.println("Línea...");
                        System.out.println(linea);
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("== Example 2 ==");
        Path dir = Paths.get(".");
        System.out.printf("%nEl arbol de archivos del proyecto para: %s es %n ", dir.toAbsolutePath());
        try (Stream<Path> streamLines = Files.walk(path)) {
            streamLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
