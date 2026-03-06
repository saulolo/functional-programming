package edu.functional_programming.unit4_streams.ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OperatorsEmployeeMain {

    public static void main(String[] args) {

        //Lista de empleados
        List<Employee> employees = Employee.employees();

        System.out.println("\n=== OPERADORES INTERMEDIOS ===");

        System.out.println("\n== ︎🔍 filter(): Filtra los elementos que cumplen una condición ==");
        System.out.println("Empleados Hombres:");
        employees.stream()
                .filter(Employee::isMan)
                .forEach(System.out::println);

        System.out.println("\nEmpleados mayores a 40 años :");
        employees.stream()
                .filter(emp -> emp.getAge() >= 40)
                .forEach(System.out::println);

        System.out.println("\nFiltro Compuesto => Empleados femeninos mayores a 40 con ingresos superiores a 100_000: ");
        Predicate<Employee> femaleEmployee = Employee::isWoman;
        Predicate<Employee> greaterThan = emp -> emp.getAge() > 40;
        Predicate<Employee> greaterIncomeThan = emp -> emp.getIncome() > 100_000;
        Predicate<Employee> compositeFilter = femaleEmployee.and(greaterThan).and(greaterIncomeThan);

        employees.stream()
                .filter(compositeFilter)
                .forEach(System.out::println);
        System.out.println("Cantidad total: " + employees.stream().filter(compositeFilter).count());

        System.out.println("\n== 🌍 map(): Transforma los elementos aplicando una función. ==");
        System.out.println("Promedio de ingreso de personal femenino: ");
        double salaryProm = employees.stream()
                .filter(Employee::isWoman)
                .mapToDouble(Employee::getIncome)
                .sum();
        double prom = salaryProm / employees.stream()
                .filter(Employee::isWoman)
                .count();
        System.out.println("El promedio es: " + prom);

        System.out.println("\n== 🗂️ sorted(): Ordena los elementos del stream. ==");
        System.out.println("Mostrando los empleados por orden alfabético: ");
        employees.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Mostrando los empleados por salario: ");
        employees.stream()
                .sorted((emp1, emp2) -> (int) (emp1.getIncome() - emp2.getIncome()))
                .forEach(System.out::println);

        System.out.println("\n== ∑ sum(): Toma una lista o colección de números y devuelve la suma total de sus elemento. ==");
        System.out.println("Sumatoria de las edades de los empleados: ");
        int sumAges = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();
        System.out.println("La sumatoria de las edades de los empleados es: " + sumAges + " y el promedio es: " + sumAges / employees.size());

        System.out.println("\n== 📊 summaryStatistics(): proporciona diversas estadísticas de resumen sobre los elementos de IntStream. ==");
        System.out.println("Aplicando el método summaryStatistics.");
        IntSummaryStatistics sumAgesStatistics = employees.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();
        System.out.println("Estadisticas => " + sumAgesStatistics);
        System.out.println("Si quiero uno de los valores ==> Suma: " + sumAgesStatistics.getSum());

        System.out.println("\n== ✂️ reduce(): Combina todos los elementos de un flujo (stream) en un único resultado final. ==");
        System.out.println("Quitar todas las comas del texto y crear otro nuevo a partir del anterior. ");
        String url = "src\\main\\java\\edu\\functional_programming\\unit4_streams\\crearStream\\Parrafo.txt";
        Path path = Paths.get(url);
        String text = "";

        try (Stream<String> lines = Files.lines(path)) {
            text = lines.map(s -> s.replace(", ", ""))
                    .reduce("", (s, s2) -> s.concat("\n").concat(s2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Parrafo2.txt"))) {
            writer.write(text);

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("\n== ~ average(): Toma una lista o colección de números y devuelve el pormedio de la sumatoria total. ==");
        double promAges = employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .getAsDouble();

        System.out.println("El promedio de las edades de los empleados es: " + promAges);

        System.out.println("\n== 🔽🔼 max() o min(): Devuelve el valor máximo o mínimo de una lista. ==");
        Employee maxAge = employees.stream()
                .max((emp1, emp2) -> (int) (emp1.getAge() - emp2.getAge())).get();

        int minAge = employees.stream()
                .mapToInt(Employee::getAge)
                .min()
                .getAsInt();

        System.out.println("El empleado con mayor edad tiene: " + maxAge + " y el de menor edad tiene: " + minAge);

        System.out.println("\n== 🧮 coun(): Cuenta la cantidad de elementos de una lista. ==");
        long countEmployees = employees.stream().count();
        //long countEmployees = employees.size();

        System.out.println("El total de empleados existentes es: " + countEmployees);

    }
}
