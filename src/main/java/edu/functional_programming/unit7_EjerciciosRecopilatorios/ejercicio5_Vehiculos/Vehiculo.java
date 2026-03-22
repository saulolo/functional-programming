package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio5_Vehiculos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehiculo {

    String matricula;
    Modelo modelo;
    Integer kilometros;

    /**
     * Retorna la representación en texto del vehículo en formato de fila de tabla.
     * @return String con los datos del vehículo alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-9s | %-10s | %6d ",
                matricula, modelo,
                kilometros != null ? kilometros : 0
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de vehículos.
     * @param vehiculos Lista de vehículos a imprimir.
     */
    public static void printTable(List<Vehiculo> vehiculos) {
        String header = String.format(
                "%-9s | %-10s | %-10s",
                "Matricula", "Modelo", "kilometros"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        vehiculos.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + vehiculos.size() + " vehículos.");
        System.out.println(separator);
    }
}
