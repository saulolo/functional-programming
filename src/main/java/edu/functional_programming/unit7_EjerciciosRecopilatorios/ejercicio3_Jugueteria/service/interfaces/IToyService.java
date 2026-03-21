package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.service.interfaces;

import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Toy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IToyService {

    /**
     * Obtiene una lista con los nombres de juguetes que tienen stock mayor a 0 y han vendido más de 50 unidades
     * en los últimos 30 días. El resultado está ordenado de mayor a menor según ventas.
     *
     * @return Lista de nombres de juguetes populares.
     */
    List<String> getPopularToyNames();

    /**
     * Calcula el precio promedio de los juguetes cuya categoría es EDUCATIONAL.
     *
     * @return Precio promedio de los juguetes educativos, o 0.0 si no existen.
     */
    Double getEducationalToysAveragePrice();

    /**
     * Obtiene un mapa con la cantidad de juguetes agrupados por categoría.
     *
     * @return Mapa donde la clave es el nombre de la categoría y el valor la cantidad de juguetes.
     */
    Map<String, Long> getToyCountByCategory();

    /**
     * Busca el juguete más caro dentro de la categoría BOARD_GAME (juegos de mesa).
     *
     * @return Optional con el juguete más caro de juegos de mesa, o vacío si no existe.
     */
    Optional<Toy> getMostExpensiveBoardGameToy();

    /**
     * Obtiene la marca en minúsculas del juguete más caro de la categoría BOARD_GAME.<br>
     * Si la marca es null o está vacía, retorna Optional vacío.
     *
     * @return Optional con la marca en minúsculas, o vacío si la marca es null/vacía o no existe juguete.
     */
    Optional<String> getBrandOfMostExpensiveBoardGameToyLowercase();

    /**
     * Devuelve una lista con los 5 juguetes de mejor calificación promedio,
     * ignorando los que tienen calificación null. El resultado está ordenado de mayor a menor puntaje.
     *
     * @return Lista con los 5 juguetes mejor calificados, o menos si no existen suficientes.
     */
    List<Toy> getTop5ByScore();

    /**
     * Obtiene un conjunto de todos los tags existentes en el catálogo, en minúsculas y sin repetidos.
     *
     * @return Set con todos los tags únicos del catálogo.
     */
    Set<String> getAllTagsLowercase();

    /**
     * Calcula el valor total potencial del inventario por categoría (precio * stock),
     * agrupado por categoría.
     *
     * @return Mapa donde la clave es la categoría y el valor es el total del inventario para esa categoría.
     */
    Map<String, Double> getTotalInventoryValueByCategory();

    /**
     * Genera una lista de alertas de reposición para juguetes cuyo stock es menor a 5,
     * con el formato "Reponer: <nombre> (stock: <stock>)".
     *
     * @return Lista de alertas de reposición.
     */
    List<String> getRestockAlerts();

    /**
     * Busca un juguete con el nombre exacto proporcionado (sensible a mayúsculas).
     *
     * @param name Nombre exacto a buscar.
     * @return Optional con el juguete encontrado, o vacío si no existe.
     */
    Optional<Toy> findToyByExactName(String name);
}
