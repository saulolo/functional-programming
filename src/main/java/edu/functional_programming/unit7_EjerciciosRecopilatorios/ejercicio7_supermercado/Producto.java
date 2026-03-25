package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio7_supermercado;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Producto {

    String nombre;
    Categoria categoria;
    Integer cantidad;
    Double precio;


    /**
     * Retorna la representación en texto de los productos en formato de fila de tabla.
     * @return String con los datos de los productos alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-10s | %-10s | %-8d | %-4.1f",
                nombre, categoria, cantidad, precio
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total los productos.
     * @param productos Lista los productos a imprimir.
     */
    public static void printTable(List<Producto> productos) {
        String header = String.format(
                "%-10s | %-10s | %-8s | %-4s",
                "Nombre", "Categoria", "Cantidad", "Precio"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        productos.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + productos.size() + " productos.");
        System.out.println(separator);
    }
}
