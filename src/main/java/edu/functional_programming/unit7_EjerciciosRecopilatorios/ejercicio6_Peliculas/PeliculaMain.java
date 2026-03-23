package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio6_Peliculas;

import java.util.*;
import java.util.stream.Collectors;

public class PeliculaMain {

    public static void main(String[] args) {

        List<Pelicula> peliculas = Arrays.asList(
                new Pelicula("E.T.", "Steven Spielberg", 1982),
                new Pelicula("Avatar", "James Cameron", 2009),
                new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998),
                new Pelicula("Origen", "Christopher Nolan", 2010),
                new Pelicula("L.A. Confidential", "Curtis Hanson", 1997)
        );


        System.out.println("=== LISTA DE PELICULAS ===");
        //Listado de películas
        Pelicula.printTable(peliculas);

        System.out.println("\n=== ESTRENOS A PARTIR DEL 2001 ===");
        //Sublistado con las peliculas estrenadas en el siglo XXI (A partir del año 2000).
        Pelicula.printTable(obtenerPeliculasDespuesDel2000(peliculas));

        System.out.println("\n=== ESTRENOS DE STEVEN SPIELBERG ===");
        //Mostrar por pantalla separados por coma, los titulos de las películas de Steven Spielberg.
        obtenerPeliculasDeStevenSpielbergSeparadoPorComas(peliculas)
                .forEach(System.out::println);

        System.out.println("\n=== NOMBRES DE PELICULAS EN ORDEN ALFABÉTICO ===");
        //Obtener un sublistado con los nombres de las peliculas ordenados alfabéticamente.
        obtenerNombresPeliculasAlfabeticamente(peliculas)
                .forEach(System.out::println);

        System.out.println("\n=== ESTRENO MAS RECIENTE ===");
        //Mostrar por pantalla el estreno mas reciente.
        Optional<Pelicula> peliculaReciente = obtenerPeliculaMasReciente(peliculas);
        String respuesta = peliculaReciente
                .map(Pelicula::toString)
                .orElse("No se encuentra una película que cumpla con dicho criterio.");
        System.out.println(respuesta);

    }

    /**
     * Retorna una lista de películas estrenadas después del año 2000.
     * @param peliculaList Lista de películas.
     * @return Lista de películas posteriores al 2000.
     */
    private static List<Pelicula> obtenerPeliculasDespuesDel2000(List<Pelicula> peliculaList) {
        return peliculaList.stream()
                .filter(pel -> pel.getEstreno() > 2000)
                .toList();
    }

    /**
     * Devuelve una lista con un solo String, donde aparecen los títulos de todas las películas dirigidas por Steven Spielberg,
     * separados por comas.
     * @param peliculaList Lista de películas.
     * @return Lista con string de películas de Steven Spielberg separadas por comas.
     */
    private static List<String> obtenerPeliculasDeStevenSpielbergSeparadoPorComas(List<Pelicula> peliculaList) {
        return Collections.singletonList(peliculaList.stream()
                .filter(pel -> pel.getDirector().equals("Steven Spielberg"))
                .map(Pelicula::getTitulo)
                .collect(Collectors.joining(", ", "Peliculas de Steven Spielberg: ", " ")));
    }

    /**
     * Retorna una lista con los títulos de todas las películas, ordenados alfabéticamente.
     * @param peliculaList Lista de películas.
     * @return Lista de títulos de películas ordenados.
     */
    private static List<String> obtenerNombresPeliculasAlfabeticamente(List<Pelicula> peliculaList) {
        return peliculaList.stream()
                .map(Pelicula::getTitulo)
                .sorted()
                .toList();
    }

    /**
     * Devuelve la película con el año de estreno más reciente.
     * @param peliculaList Lista de películas.
     * @return Optional con la película más reciente, o vacío si la lista está vacía.
     */
    private static Optional<Pelicula> obtenerPeliculaMasReciente(List<Pelicula> peliculaList) {
        return peliculaList.stream()
                .max(Comparator.comparing(Pelicula::getEstreno));
    }

}
