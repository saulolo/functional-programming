package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Toy {

    Long id;
    String name;
    Category category;
    Integer minimumAge;
    Integer price;
    Integer stock;
    String brand;
    Double score;
    Integer salesLast30Days;
    List<String> tags;


    /**
     * Retorna la representación en texto del juguete en formato de fila de tabla.
     * @return String con los datos del juguete alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-2d | %-25s | %-12s | %3d | %8d | %6d | %-14s | %4.1f | %5d | %4d",
                id, name, category, minimumAge, price, stock,
                brand != null && !brand.isEmpty() ? brand : "<none>",
                score != null ? score : 0.0,
                salesLast30Days != null ? salesLast30Days : 0,
                tags != null ? tags.size() : 0
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de juguetes.
     * @param toys Lista de juguetes a imprimir.
     */

    public static void printTable(List<Toy> toys) {
        String header = String.format(
                "%-2s | %-25s | %-12s | %3s | %8s | %6s | %-14s | %4.1s | %5s | %4s",
                "ID", "Name", "Category", "Age", "Price", "Stock", "Brand", "Score", "Sales", "#Tags"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        toys.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + toys.size() + " toys.");
        System.out.println(separator);
    }
}
