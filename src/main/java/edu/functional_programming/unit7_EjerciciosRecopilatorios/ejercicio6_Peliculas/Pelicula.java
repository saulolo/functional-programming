package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio6_Peliculas;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pelicula {

    String titulo;
    String director;
    Integer estreno;
    Boolean chord;

    public Pelicula(String titulo, String director, Integer estreno) {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    /**
     * Retorna la representación en texto de una pelicula en formato de fila de tabla.
     * @return String con los datos de la pelicula alineados en columnas.
     */
    @Override
    public String toString() {
        return String.format(
                "%-23s | %-18s | %-8d | %-4s",
                titulo, director, estreno, chord
        );
    }

    /**
     * Imprime en consola una tabla formateada con encabezado, filas y total de peliculas.
     * @param peliculas Lista de peliculas a imprimir.
     */
    public static void printTable(List<Pelicula> peliculas) {
        String header = String.format(
                "%-23s | %-18s | %-8s | %-4s",
                "Titulo", "Director", "Estreno", "chord"
        );
        String separator = "=".repeat(header.length());
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        peliculas.forEach(System.out::println);
        System.out.println(separator);
        System.out.println("Total: " + peliculas.size() + " películas.");
        System.out.println(separator);
    }
}
