package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio7_supermercado;

import java.util.*;
import java.util.stream.Collectors;

public class ProductoMain {

    public static void main(String[] args) {

        //Lista de productos
        List<Producto> productos = Arrays.asList(
                new Producto("Manzana", Categoria.FRUTAS, 1, 2.5),
                new Producto("Leche", Categoria.LACTEOS, 2, 1.2),
                new Producto("Pan", Categoria.PANADERIA, 5, 1.0),
                new Producto("Yogur", Categoria.LACTEOS, 3, 1.8),
                new Producto("Pera", Categoria.FRUTAS, 4, 3.0),
                new Producto("Naranja", Categoria.FRUTAS, 6, 2.0),
                new Producto("Queso", Categoria.LACTEOS, 2, 3.5),
                new Producto("Manteca", Categoria.LACTEOS, 1, 2.2),
                new Producto("Harina", Categoria.LACTEOS, 3, 1.5),
                new Producto("Arroz", Categoria.ALIMENTOS, 4, 1.8),
                new Producto("Tomate", Categoria.FRUTAS, 5, 1.2),
                new Producto("Lechuga", Categoria.VERDURAS, 2, 0.9),
                new Producto("Pescado", Categoria.PESCADERIA, 1, 4.0),
                new Producto("Pollo", Categoria.CARNES, 3, 5.0),
                new Producto("Carne", Categoria.CARNES, 2, 6.5)
        );


        System.out.println("=== LISTADO DE PRODUCTOS ===");
        //Listado de productos
        Producto.printTable(productos);

        System.out.println("\n=== FRUTAS ===");
        //Filtar los productos de la categoria frutas
        Producto.printTable(obtenerProductosPorFrutas(productos));

        System.out.println("\n=== PRECIO TOTAL LÁCTEOS ===");
        //Calcular el precio total de todos los productos en la categoria lácteos.
        System.out.println(obtenerPrecioTotalLacteos(productos));

        System.out.println("\n=== PRODUCTO CON EL PRECIO MAS BAJO ===");
        //Obtener el producto con el precio mas bajo.
        System.out.println(obtenerProductoPrecioMasBajo(productos));

        System.out.println("\n=== PRODUCTOS POR CATEGORIA ===");
        //Agrupar los productos por categoria.
        Map<Categoria, List<Producto>> agrupados = obtenerProductoPorCategoria(productos);

        agrupados.forEach((categoria, productoList) -> {
            System.out.println("\nCategoria: " + categoria);
            Producto.printTable(productoList);

        });

        System.out.println("\n=== PRECIO PROMEDIO POR CATEGORIA Y EL MAS ALTO DE ESOS PRODUCTOS ===");
        /*Calcular el precio promedio de los productos de cada categoria y mostrar la categoria con el precio promedio
        mas alto. Utilizar parallel stream porque se puede majenr muchos datos.*/
        //Agrupar los productos por categoria.
        Map<Categoria, Double> agrupadosCategoria = obtenerPrecioPromedioPorCategoria(productos);
        agrupadosCategoria.forEach((categoria, pro) -> {
            System.out.println("\nCategoria: " + categoria);
            System.out.println(pro);
        });
        obtenerPrecioPromedioMasAltoPorCategoria(productos)
                .ifPresentOrElse(
                        cat -> System.out.println("\nCategoría con mayor promedio: " + cat),
                        () -> System.out.println("No hay categorías disponibles.")
                );

    }

    /**
     * Filtra y retorna los productos de la categoría FRUTAS.
     * @param productoList Lista de productos.
     * @return Lista de productos de la categoría FRUTAS.
     */
    private static List<Producto> obtenerProductosPorFrutas(List<Producto> productoList) {
        return productoList.stream()
                .filter(prod -> prod.getCategoria().equals(Categoria.FRUTAS))
                .toList();
    }

    /**
     * Calcula el precio total de todos los productos de la categoría LACTEOS.
     * @param productoList Lista de productos.
     * @return Precio total de los productos lácteos.
     */
    private static double obtenerPrecioTotalLacteos(List<Producto> productoList) {
        return productoList.stream()
                .filter(prod -> prod.getCategoria().equals(Categoria.LACTEOS))
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    /**
     * Obtiene el producto con el precio más bajo.
     * @param productoList Lista de productos.
     * @return Optional con el producto de menor precio, o vacío si la lista está vacía.
     */
    private static Optional<Producto> obtenerProductoPrecioMasBajo(List<Producto> productoList) {
        return productoList.stream()
                .min(Comparator.comparingDouble(Producto::getPrecio));
    }

    /**
     * Agrupa los productos por categoría.
     * @param productoList Lista de productos.
     * @return Mapa de categoría a la lista de productos de esa categoría.
     */
    private static Map<Categoria, List<Producto>> obtenerProductoPorCategoria(List<Producto> productoList) {
        return productoList.stream()
                .collect(Collectors
                        .groupingBy(Producto::getCategoria));
    }

    /**
     * Calcula el precio promedio de los productos para cada categoría.
     * @param productoList Lista de productos.
     * @return Mapa de categoría a precio promedio.
     */
    private static Map<Categoria, Double> obtenerPrecioPromedioPorCategoria(List<Producto> productoList) {
        return productoList.parallelStream()
                .collect(Collectors
                        .groupingBy(Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)));
    }

    /**
     * Obtiene la categoría con el precio promedio más alto.
     * @param productoList Lista de productos.
     * @return Optional con la categoría de mayor precio promedio, o vacío si la lista está vacía.
     */
    private static Optional<Categoria> obtenerPrecioPromedioMasAltoPorCategoria(List<Producto> productoList) {
        return obtenerPrecioPromedioPorCategoria(productoList).entrySet().parallelStream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

}
