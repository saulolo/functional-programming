package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.controller;

import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Toy;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.service.interfaces.IToyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jugueteria/analisis")
public class ToyController {

    private final IToyService toyService;


    /**
     * Punto 1: Devuelve una lista de nombres de juguetes que tienen stock > 0 y vendieron más de 50 unidades
     * en los últimos 30 días, ordenados de mayor a menor por ventas.
     *
     * @return Lista de nombres de juguetes populares.
     */
    @GetMapping("/punto1")
    public List<String> getPopularToyNames() {
        return toyService.getPopularToyNames();
    }

    /**
     * Punto 2: Devuelve el precio promedio de los juguetes con categoría EDUCATIONAL.
     *
     * @return Precio promedio de juguetes educativos.
     */
    @GetMapping("/punto2")
    public Double getEducationalToysAveragePrice() {
        return toyService.getEducationalToysAveragePrice();
    }

    /**
     * Punto 3: Devuelve la cantidad de juguetes agrupados por categoría.
     *
     * @return Mapa de categoría a cantidad de juguetes.
     */
    @GetMapping("/punto3")
    public Map<String, Long> getToyCountByCategory() {
        return toyService.getToyCountByCategory();
    }

    /**
     * Punto 4: Devuelve el juguete más caro dentro de la categoría BOARD_GAME (juegos de mesa).
     *
     * @return Optional con el juguete más caro de juegos de mesa, o vacío si no existe.
     */
    @GetMapping("/punto4")
    Optional<Toy> getMostExpensiveBoardGameToy() {
        return toyService.getMostExpensiveBoardGameToy();
    }

    /**
     * Punto 5: Devuelve la marca en minúsculas del juguete más caro de la categoría BOARD_GAME.
     * Si la marca es null o vacía retorna Optional vacío.
     *
     * @return Optional con la marca en minúsculas, o vacío si no existe o es vacía.
     */
    @GetMapping("/punto5")
    public Optional<String> getBrandOfMostExpensiveBoardGameToyLowercase() {
        return toyService.getBrandOfMostExpensiveBoardGameToyLowercase();
    }

    /**
     * Punto 6: Devuelve los 5 juguetes con mejor calificación promedio, ignorando los que tienen score null.
     *
     * @return Lista de hasta 5 juguetes mejor calificados.
     */
    @GetMapping("/punto6")
    public List<Toy> getTop5ByScore() {
        return toyService.getTop5ByScore();
    }

    /**
     * Punto 7: Devuelve un conjunto de todos los tags existentes en el catálogo, en minúsculas y sin repetidos.
     *
     * @return Set de tags únicos en minúsculas.
     */
    @GetMapping("/punto7")
    public Set<String> getAllTagsLowercase() {
        return toyService.getAllTagsLowercase();
    }

    /**
     * Punto 8: Devuelve el valor total potencial del inventario por categoría (precio * stock).
     *
     * @return Mapa de categoría a total en pesos del inventario para esa categoría.
     */
    @GetMapping("/punto8")
    public Map<String, Double> getTotalInventoryValueByCategory() {
        return toyService.getTotalInventoryValueByCategory();
    }

    /**
     * Punto 9: Devuelve una lista de alertas de reposición para juguetes con stock menor a 5,
     * en el formato "Reponer: <nombre> (stock: <stock>)".
     *
     * @return Lista de alertas de reposición.
     */
    @GetMapping("/punto9")
    public List<String> getRestockAlerts() {
        return toyService.getRestockAlerts();
    }

    /**
     * Punto 10: Busca si existe un juguete con nombre exacto, devolviendo un Optional con el juguete si existe.
     *
     * @param name Nombre exacto buscado (case sensitive).
     * @return Optional con el juguete, o vacío si no existe.
     */
    @GetMapping("/punto10")
    public Optional<Toy> findToyByExactName(String name) {
        return toyService.findToyByExactName(name);
    }

}
