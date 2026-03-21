package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio2_Ecommerce;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    String code;
    String productName;
    Category category;
    Integer quantity;
    Integer unitPrice;

    /**
     * Retorna la representación en texto del producto en formato de fila de tabla.
     * @return String con los datos del producto alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-5s | %-20s | %-10s | %-6d | %-6d",
                code, productName, category, quantity, unitPrice
        );
    }


    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de productos.
     * @param products Lista de productos a imprimir.
     */
    public static void printTable(java.util.List<Product> products) {
        String header = String.format(
                "%-5s | %-20s | %-10s | %-6s | %-10s",
                "COD", "NombreProducto", "Categoría", "Cant.", "Precio"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        products.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + products.size() + " productos.");
        System.out.println(separator);
    }
}
