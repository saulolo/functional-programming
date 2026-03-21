package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio2_Ecommerce;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Una tienda online registra los pedidos de sus clientes. Cada Pedido tiene: id, nombreCliente, emailCliente, total,
 * estado (pendiente, pagado, cancelado), metodoPago (tarjeta, transferencia, efectivo), listaProductos.
 * Por otro lado, cada Producto de la lista de productos tiene: codigo, nombreProducto, categoria (tecno, hogar,
 * libros), cantidad, precioUnitario.
 * A partir de estos datos, se ha obtenido una lista de los últimos pedidos realizados y es la siguiente: (Instancia de pedidos).
 * A partir de estos datos, resolver los siguientes puntos utilizando lambdas y streams junto con Optionals o parallel
 * streams (donde sea necesario):
 * <p>1. Obtener una lista con los IDs de los pedidos en estado «pagado» cuyo total sea mayor a $50.000, ordenados de
 * mayor a menor según el total del pedido.<p/>
 * <p>2. Calcular el total facturado, considerando únicamente los pedidos con estado «pagado».<p/>
 * <p>3. Generar un Map<String, Long> que indique la cantidad de pedidos por estado (ejemplo: «pagado» = 8).<p/>
 * <p>4. Obtener los 3 productos más vendidos, considerando la cantidad total vendida (sumando cantidades de distintos
 * pedidos). Solo deben considerarse productos de pedidos «pagado». Pista: podés usar flatMap() para recorrer listaProductos.<p/>
 * <p>5. Calcular el monto total vendido por categoría, considerando únicamente pedidos «pagado». EI resultado debe ser
 * un Map<String,Double> (Por ejemplo: «tecno» = 425000.0)<p/>
 * <p>6. Obtener el pedido de mayor total entre los pedidos «pagado», devolviendo un Optional<Pedido>.<p/>
 * <p>7. A partir del punto anterior, obtener un Optional<String> con el email del cliente del pedido más caro:
 * <p>• Si el email es null o está vacío, el Optional debe quedar vacío.<p/>
 * <p>• Si existe, devolverlo en minúsculas.<p/>
 * <p>• No usar if. Resolver encadenando operaciones con Optional.<p/>
 * <p>8. Calcular el total facturado del punto 2 utilizando parallelStream(). Comparar el resultado con el cálculo
 * realizado con stream() y verificar si coinciden o hay diferencias de tiempo de procesamiento.
 * <p>• En base a los tiempos adquiridos... ¿Conviene en este caso utilizar Parallel Streams o se obtienen mejores resultados
 * de forma secuencial?<p/><p/>
 * @author Saul Echeverri
 */
public class EcommerceMain {

    public static void main(String[] args) {

        List<Order> orderList =OrdersDataset.getOrdersFromDB();

        System.out.println("=== TIENDA ONLINE ===");

        System.out.println("\n1. IDs de Pedidos pagados: ");
        List<Long> ids = getPaidOrderIdsWithTotalAbove(orderList);
        ids.forEach(System.out::println);

        System.out.println("\n============================================");
        System.out.println("\n2. Total facturado Pedidos pagados: ");
        int total = getTotalPaidRevenue(orderList);
        System.out.printf("$%,d%n", total);

        System.out.println("\n============================================");
        Map<String, Long> ordersCountByState = getOrderCountByState(orderList);
        System.out.println("\n3. Cantidad de pedidos por estado:");
        ordersCountByState.forEach((state, count) ->
                System.out.println(state + " → " + count));

        System.out.println("\n============================================");
        List<String> top3Products = getTop3BestSellingProducts(orderList);
        System.out.println("\n4. Los 3 productos más vendidos:");
        top3Products.forEach(System.out::println);

        System.out.println("\n============================================");
        Map<Category, Double> revenueByCategory = getTotalRevenueByCategory(orderList);
        System.out.println("\n5. Monto vendido por categoría:");
        revenueByCategory.forEach((category, totalMount) ->
                System.out.printf("%-10s → $%.2f%n", category, totalMount));

        System.out.println("\n============================================");
        Optional<Order> highestOrder = getHighestPaidOrder(orderList);
        if (highestOrder.isPresent()) {
            System.out.println("\n6. Pedido pagado más caro:");
            System.out.println(highestOrder.get());
        } else {
            System.out.println("No hay pedidos pagados.");
        }

        System.out.println("\n============================================");
        System.out.println("\nParallelStream");
        Optional<String> mostExpensiveEmail = getEmailOfHighestPaidOrder(orderList);
        mostExpensiveEmail.ifPresentOrElse(
                email -> System.out.println("\n7. Email del pedido pagado más caro (minúsculas): " + email),
                () -> System.out.println("No hay email válido para el pedido más caro pagado.")
        );

        System.out.println("\n============================================");
        long startSeq = System.nanoTime();
        int totalSeq = getTotalPaidRevenue(orderList);
        long endSeq = System.nanoTime();
        double timeSeq = (endSeq - startSeq) / 1_000_000.0;

        long startPar = System.nanoTime();
        int totalPar = getTotalPaidRevenueParallel(orderList);
        long endPar = System.nanoTime();
        double timePar = (endPar - startPar) / 1_000_000.0;

        System.out.println("Total facturado (stream): " + totalSeq + " en " + timeSeq + " ms");
        System.out.println("Total facturado (parallelStream): " + totalPar + " en " + timePar + " ms");

        if (totalSeq == totalPar) {
            System.out.println("Los totales coinciden.");
        } else {
            System.out.println("Los totales NO coinciden.");
        }

        System.out.println("¿Conviene usar parallelStream?");
        if (timePar < timeSeq) {
            System.out.println("Para este caso (lista pequeña), la diferencia de tiempo es mínima o nula. ParallelStream no aporta ventajas.");
        } else {
            System.out.println("Para este caso, la secuencia es igual o más rápida. ParallelStream es más útil en colecciones MUY grandes.");
        }

    }

    /**
     * Obtiene una lista de IDs de los pedidos pagados cuyo total es mayor a $50.000,
     * ordenados de mayor a menor según su total.
     * @param orders Lista de pedidos.
     * @return Lista de IDs de pedidos.
     */
    public static List<Long> getPaidOrderIdsWithTotalAbove(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getState() == State.PAID && o.getTotal() > 50_000)
                .sorted((o1, o2) -> o2.getTotal().compareTo(o1.getTotal()))
                .map(Order::getId)
                .toList();
    }

    /**
     * Calcula el total facturado sumando el total de todos los pedidos pagados.
     * @param orders Lista de pedidos.
     * @return Monto total facturado.
     */
    public static Integer getTotalPaidRevenue(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getState() == State.PAID)
                .mapToInt(Order::getTotal)
                .sum();
    }

    /**
     * Genera un mapa con la cantidad de pedidos por cada estado.
     * @param orders Lista de pedidos.
     * @return Mapa donde la clave es el nombre del estado y el valor la cantidad de pedidos.
     */
    public static Map<String, Long> getOrderCountByState(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getState().name(),
                        Collectors.counting()
                ));
    }

    /**
     * Obtiene una lista de los 3 productos más vendidos según la suma de cantidades,
     * considerando solo pedidos pagados.
     * @param orders Lista de pedidos.
     * @return Lista de nombres de los tres productos más vendidos.
     */
    public static List<String> getTop3BestSellingProducts(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getState() == State.PAID)
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getProductName,
                        Collectors.summingInt(Product::getQuantity)
                ))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    /**
     * Calcula el monto total vendido por cada categoría, considerando únicamente pedidos pagados.
     * @param orders Lista de pedidos.
     * @return Mapa con la categoría como clave y el monto total vendido como valor.
     */
    public static Map<Category, Double> getTotalRevenueByCategory(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getState() == State.PAID)
                .flatMap(order -> order.getProducts().stream())
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.summingDouble(
                                        p -> p.getQuantity() * p.getUnitPrice()
                                )
                        )
                );
    }

    /**
     * Encuentra el pedido pagado con mayor total.
     * @param orders Lista de pedidos.
     * @return Optional con el pedido de mayor total entre los pagados, o empty si no hay.
     */
    public static Optional<Order> getHighestPaidOrder(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getState() == State.PAID)
                .max(Comparator.comparing(Order::getTotal));
    }

    /**
     * Obtiene el email en minúsculas del cliente del pedido más caro pagado.
     * Si el email es null o vacío, retorna Optional vacío.
     * @param orders Lista de pedidos.
     * @return Optional con el email del cliente en minúsculas.
     */
    public static Optional<String> getEmailOfHighestPaidOrder(List<Order> orders) {
        return getHighestPaidOrder(orders)
                .map(Order::getEmail)
                .filter(email -> email != null && !email.isEmpty())
                .map(String::toLowerCase);
    }

    /**
     * Calcula el total facturado usando parallelStream para pedidos pagados.
     * @param orders Lista de pedidos.
     * @return Monto total facturado.
     */
    public static int getTotalPaidRevenueParallel(List<Order> orders) {
        return orders.parallelStream()
                .filter(order -> order.getState() == State.PAID)
                .mapToInt(Order::getTotal)
                .sum();
    }

}
