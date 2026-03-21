package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio2_Ecommerce;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    Long id;
    String customerName;
    String email;
    Integer total;
    State state;
    PaymentMethod paymentMethod;
    List<Product> products;

    /**
     * Retorna la representación en texto de la orden en formato de fila de tabla.
     * @return String con los datos de la orden alineados en columnas.
     */
    @Override
    public String toString() {
        // Solo imprimimos id, customerName, email, total, state, paymentMethod, y cantidad de productos
        return String.format(
                "%-3d | %-15s | %-20s | %-8d | %-10s | %-10s | %-8d",
                id, customerName, email, total, state, paymentMethod, products.size()
        );
    }


    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de pedidos.
     * @param orders Lista de pedidos a imprimir.
     */
    public static void printTable(List<Order> orders) {
        String header = String.format(
                "%-3s | %-15s | %-20s | %-8s | %-10s | %-10s | %-8s",
                "ID", "Cliente", "Email", "Total", "Estado", "MétodoPago", "#Prod."
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        orders.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + orders.size() + " pedidos.");
        System.out.println(separator);
    }

}
