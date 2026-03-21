package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.repository;

import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Category;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Toy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ToyRepository {

    private final AtomicLong SequenceId = new AtomicLong(20);

    public List<Toy> getToysFromDB() {
        return List.of(
                new Toy(1L, "LEGO City", Category.CONSTRUCTION, 6, 89999, 8,
                        "LEGO", 4.8, 120, List.of("novedad", "coleccion", "bloques")),
                new Toy(2L, "Barbie Fashion", Category.DOLL, 5, 34999, 3, "Mattel", 4.6, 70,
                        List.of("muñeca", "moda")),
                new Toy(3L, "Puzzle 1000 piezas", Category.BOARD_GAME, 10, 18999, 15, "Ravensburger", 4.7, 55,
                        List.of("puzzle", "familia")),
                new Toy(4L, "Autito a control remoto", Category.OUTDOOR, 8, 27999, 4, "Nikko", 4.2, 65,
                        List.of("rc", "velocidad")),
                new Toy(5L, "Juego de ajedrez", Category.BOARD_GAME, 7, 15999, 2, "Generico", 4.1, 40,
                        List.of("estrategia", "clasico")),
                new Toy(6L, "Bloques de madera", Category.EDUCATIONAL, 3, 12999, 20, "WoodKids", 4.5, 90,
                        List.of("madera", "didactico")),
                new Toy(7L, "Cocinita", Category.DOLL, 4, 45999, 1, "MundoMimo", 4.0, 35,
                        List.of("rol", "cocina")),
                new Toy(8L, "Pelota fútbol", Category.OUTDOOR, 5, 9999, 25, "Adidas", 4.3, 110,
                        List.of("deporte", "airelibre")),
                new Toy(9L, "Set plastilina", Category.EDUCATIONAL, 3, 7999, 0, "Play-Doh", 4.4, 85,
                        List.of("creatividad", "manualidades")),
                new Toy(10L, "Tren de encastre", Category.EDUCATIONAL, 2, 10999, 6, null, 4.1, 30,
                        List.of("encastre", "motores")),
                new Toy(11L, "Nerf Elite", Category.OUTDOOR, 8, 39999, 5, "Nerf", null, 95,
                        List.of("accion", "blaster")),
                new Toy(12L, "Rompecabezas infantil 50", Category.EDUCATIONAL, 3, 6999, 18, "Generico", 3.9, 25,
                        List.of("puzzle", "infantil")),
                new Toy(13L, "Muñeco superhéroe", Category.DOLL, 6, 19999, 9, "", 4.0, 60,
                        List.of("accion", "coleccion")),
                new Toy(14L, "Carpa infantil", Category.OUTDOOR, 4, 29999, 7, "KidsCamp", 4.2, 45,
                        List.of("airelibre", "aventura")),
                new Toy(15L, "Dominó clásico", Category.BOARD_GAME, 6, 8999, 12, "Generico", 4.0, 50,
                        List.of("familia", "clasico")),
                new Toy(16L, "Kit ciencia volcan", Category.EDUCATIONAL, 8, 24999, 2, "CienciaPro", 4.6, 75,
                        List.of("ciencia", "experimentos")),
                new Toy(17L, "Set construcción imanes", Category.CONSTRUCTION, 5, 27999, 10, "MagBuild", 4.7, 80,
                        List.of("imanes", "bloques")),
                new Toy(18L, "Pista de autos", Category.CONSTRUCTION, 6, 55999, 3, "Hot Wheels", 4.5, 105,
                        List.of("autos", "pista")),
                new Toy(19L, "Uno", Category.BOARD_GAME, 7, 6499, 30, "Mattel", 4.8, 200,
                        List.of("cartas", "familia")),
                new Toy(20L, "Muñeco peluche oso", Category.DOLL, 2, 11999, 14, "PeluKids", 4.4, 95,
                        List.of("peluche", "suave")));

    }
}
