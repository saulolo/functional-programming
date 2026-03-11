package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio1_Veterinaria;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attention {

    Long id;
    String petName;
    String species;
    String tutorName;
    String service;
    Integer cost;

    /**
     * Retorna la representación en texto del estudiante en formato de fila de tabla.
     * @return String con los datos del estudiante alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-3d | %-6s | %-8s | %-8s | %-12s | %-6d",
                id, petName, species, tutorName, service, cost
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de atenciones.
     * @param students Lista de estudiantes a imprimir.
     */
    public static void printTable(List<Attention> attentions) {
        String header = String.format(
                "%-3s | %-6s | %-8s | %-8s | %-12s | %-6s",
                "ID", "Nombre", "Especie", "Tutor", "Servicio", "Costo"

        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        attentions.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + attentions.size() + " mascotas.");
        System.out.println(separator);
    }

}
