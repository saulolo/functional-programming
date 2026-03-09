package edu.functional_programming.unit6_IAS_training_exercises;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    Long id;
    String firstName;
    String lastName;
    Integer age;
    String gender;
    Integer grade;
    String group;
    String ethnicGroup;

    /**
     * Retorna la representación en texto del estudiante en formato de fila de tabla.
     * @return String con los datos del estudiante alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-3d | %-9s %-10s | %-3d años | Grado: %-3d | %-7s | %-6s | %-5s",
                id, firstName, lastName, age, grade, gender, group, ethnicGroup
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de estudiantes.
     * @param students Lista de estudiantes a imprimir.
     */
    public static void printTable(List<Student> students) {
        String header = String.format(
                "%-3s | %-9s %-10s | %-8s | %-10s | %-7s | %-6s | %-8s",
                "ID", "Nombre", "Apellido", "Edad", "Grado", "Genero", "Grupo", "Etnia"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        students.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + students.size() + " estudiantes.");
        System.out.println(separator);
    }

}
