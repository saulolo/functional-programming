package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio5_Vehiculos;

import java.util.*;
import java.util.stream.Collectors;

public class VehiculoMain {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = Arrays.asList(
                new Vehiculo("ABC-1234", Modelo.TOYOTA, 45_000),
                new Vehiculo("XYZ-9876", Modelo.HONDA, 120_500),
                new Vehiculo("DEF-4567", Modelo.FORD, 88_200),
                new Vehiculo("GHI-1011", Modelo.TOYOTA, 15_300),
                new Vehiculo("JKL-2022", Modelo.CHEVROLET, 62_000),
                new Vehiculo("MNO-3033", Modelo.VOLKSWAGEN, 95_150),
                new Vehiculo("PQR-4044", Modelo.HONDA, 34_000),
                new Vehiculo("STU-5055", Modelo.NISSAN, 110_000),
                new Vehiculo("VWX-6066", Modelo.MAZDA, 27_800),
                new Vehiculo("YZA-7077", Modelo.TOYOTA, 210_000)
        );


        System.out.println("=== LISTA DE VEHICULOS ===");
        //Listado de vehículos
        Vehiculo.printTable(vehiculos);

        System.out.println("\n=== KM X 2 ===");
        //Listar los km's de cada vehiculo y multiplicarlo por 2.
        obtenerKilometrosX2(vehiculos)
                .forEach(System.out::println);

        System.out.println("\n=== LISTA DE KM ===");
        //Listar los km's de todos los vehiculos.
        obtenerKilometros(vehiculos)
                .forEach(System.out::println);

        System.out.println("\n=== VEHICULOS MODELO TOYOTA ===");
        //Listar los vehiculos solo con modelo Toyota.
        Vehiculo.printTable(obtenerVehiculosToyota(vehiculos));

        System.out.println("\n=== VEHICULOS ORDENADOS X KM ===");
        //Ordenar los vehiculos por la cantidad de kilometros.
        Vehiculo.printTable(obtenerVehiculosOrdenadosPorKm(vehiculos));

        System.out.println("\n=== VEHICULOS X MODELO SIN REPETIR ===");
        //Listar todos los modelos sin que se repitam.
        obtenerVehiculosPorModeloSinRepetir(vehiculos)
                .forEach(System.out::println);

        System.out.println("\n=== VEHICULOS X MODELO SIN REPETIR (DISTINCT) ===");
        //Listar todos los modelos sin que se repitam.
        obtenerVehiculosPorModeloSinRepetirDistinct(vehiculos)
                .forEach(System.out::println);

        System.out.println("\n=== VEHICULOS MAYORES A 100.000 KM ===");
        //Listar los vehiculos con mas de 100.000 km.
        Vehiculo.printTable(obtenerVehiculosMayoresA100_000(vehiculos));

        System.out.println("\n=== AGRUPAR VEHICULOS X MODELO ===");
        //Agrupar los vehiculos por modelo.
        Map<Modelo, List<Vehiculo>> agrupados = obtenerVehiculosAgrupadosPorModelo(vehiculos);

        agrupados.forEach((modelo, listaVehiculos) -> {
            System.out.println("\nModelo: " + modelo);
            Vehiculo.printTable(listaVehiculos);
        });

        System.out.println("\n=== TOTAL KM DE VEHICULOS ===");
        //Sumar los kilometros de los vehiculos .
        System.out.println(obtenerTotalKmVehiculos(vehiculos));

        System.out.println("\n=== 2 VEHICULOS CON KM MENORES O IGUALES A 100.000 ===");
        //Listar 2 vehiculos con Km's <= a 100.000
        //Vehiculo.printTable(obtener2VehiculosConKmMenorIgualA100_000(vehiculos));
        System.out.println(obtener2VehiculosConKmMenorIgualA100_000(vehiculos));

    }

    /**
     * Devuelve una lista con los kilómetros de cada vehículo multiplicados por 2.
     * @param vehiculoList Lista de vehículos.
     * @return Lista de kilómetros x2.
     */
    private static List<Integer> obtenerKilometrosX2(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .map(v -> v.getKilometros() * 2)
                .toList();
    }

    /**
     * Obtiene una lista con los kilómetros de todos los vehículos.
     * @param vehiculoList Lista de vehículos.
     * @return Lista de kilómetros.
     */
    private static List<Integer> obtenerKilometros(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .map(Vehiculo::getKilometros)
                .toList();
    }

    /**
     * Filtra los vehículos de modelo TOYOTA.
     * @param vehiculoList Lista de vehículos.
     * @return Lista de vehículos TOYOTA.
     */
    private static List<Vehiculo> obtenerVehiculosToyota(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .filter(v -> v.getModelo().equals(Modelo.TOYOTA))
                .toList();
    }

    /**
     * Devuelve los vehículos ordenados de menor a mayor según los kilómetros.
     * @param vehiculoList Lista de vehículos.
     * @return Lista ordenada por kilómetros.
     */
    private static List<Vehiculo> obtenerVehiculosOrdenadosPorKm(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .sorted((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un conjunto de modelos presentes en la lista, sin repetir.
     * @param vehiculoList Lista de vehículos.
     * @return Set de modelos únicos.
     */
    private static Set<Modelo> obtenerVehiculosPorModeloSinRepetir(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .map(Vehiculo::getModelo)
                .collect(Collectors.toSet());
    }

    /**
     * Obtiene una lista de modelos únicos, conservando el primer orden encontrado.
     * @param vehiculoList Lista de vehículos.
     * @return Lista de modelos únicos (distinct).
     */
    private static List<Modelo> obtenerVehiculosPorModeloSinRepetirDistinct(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .map(Vehiculo::getModelo)
                .distinct()
                .toList();
    }

    /**
     * Filtra los vehículos con más de 100,000 kilómetros.
     * @param vehiculoList Lista de vehículos.
     * @return Lista de vehículos con kilómetros > 100,000.
     */
    private static List<Vehiculo> obtenerVehiculosMayoresA100_000(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .filter(v -> v.getKilometros() > 100_000)
                .toList();
    }

    /**
     * Agrupa los vehículos por modelo.
     * @param vehiculoList Lista de vehículos.
     * @return Mapa de modelo a lista de vehículos.
     */
    private static Map<Modelo, List<Vehiculo>> obtenerVehiculosAgrupadosPorModelo(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .collect(Collectors
                        .groupingBy(Vehiculo::getModelo));
    }

    /**
     * Calcula el total de kilómetros de todos los vehículos.
     * @param vehiculoList Lista de vehículos.
     * @return Total acumulado de kilómetros.
     */
    private static Integer obtenerTotalKmVehiculos(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .mapToInt(Vehiculo::getKilometros)
                .sum();
    }

    /**
     * Obtiene hasta dos modelos distintos de vehículos con kilómetros menores o iguales a 100,000.
     * @param vehiculoList Lista de vehículos.
     * @return Lista de hasta dos modelos distintos.
     */
    private static List<Modelo> obtener2VehiculosConKmMenorIgualA100_000(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .filter(v -> v.getKilometros() <= 100_000)
                .map(Vehiculo::getModelo)
                .distinct()
                .limit(2)
                .toList();
    }

}
