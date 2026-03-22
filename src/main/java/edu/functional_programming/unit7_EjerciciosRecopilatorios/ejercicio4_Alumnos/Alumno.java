package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio4_Alumnos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Alumno {

    Long id;
    String cedula;
    String nombre;
    String apellido;
    String nombreCurso;
    Double nota;
    Integer edad;


    /**
     * Retorna la representación en texto del alumno en formato de fila de tabla.
     * @return String con los datos del alumno alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-2d | %-10s | %-10s | %-10s | %-14s | %4.1f | %2d ",
                id, cedula, nombre, apellido, nombreCurso, nota, edad,
                nota != null ? nota : 0.0,
                edad != null ? edad : 0
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de alumnos.
     * @param alumnos Lista de alumnos a imprimir.
     */

    public static void printTable(List<Alumno> alumnos) {
        String header = String.format(
                "%-2s | %-10s | %-10s | %-10s | %14s | %4s | %2s",
                "ID", "Cédula", "Nombre", "Apellido", "Nombre Curso", "Nota", "Edad"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        alumnos.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + alumnos.size() + " alumnos.");
        System.out.println(separator);
    }
}
