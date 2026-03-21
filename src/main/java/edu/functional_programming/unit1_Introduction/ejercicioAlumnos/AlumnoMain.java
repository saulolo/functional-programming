package edu.functional_programming.unit1_Introduction.ejercicioAlumnos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlumnoMain {

    public static void main(String[] args) {

        List<Alumno> alumnos = Arrays.asList(
                new Alumno(1L, "1313131313", "Saul", "Echeverri", "Java", 5.0, 40),
                new Alumno(2L, "1212121212", "Felipe", "Vasquez", "Python", 3.0, 41),
                new Alumno(3L, "1111111111", "Alejandra", "Arenas", "Java", 4.0, 39),
                new Alumno(4L, "1414141414", "Leidy", "Zapata", "Goland", 2.0, 39),
                new Alumno(5L, "1515151515", "Diego", "Martinez", "JavaScript", 3.4, 41)
        );

        //1. Listar Alumnos
        System.out.println("=== LISTA ALUMNOS ===");
        listarAlumnos(alumnos);

        //2. Obtener alumnos cuyo nombre empiezen con L o S
        System.out.println("\n=== ALUMNOS QUE EMPIEZAN CON LA LETRA 'L' Ó 'S' ===");
        List<Alumno> nombreAlumnos = obtenerAlumnosPorIniciales(alumnos);
        Alumno.printTable(nombreAlumnos);

        //3. Obtener el número de alumnos
        System.out.println("\n=== NÚMERO DE ALUMNOS ===");
        System.out.println(obtenerNumeroAlumnos(alumnos));

        //4. Obtener alumno con menor edad
        System.out.println("\n=== ALUMNO CON MENOR EDAD ===");
        System.out.println(obtenerAlumnoMenor(alumnos));

        //5. Obtener alumno con major edad
        System.out.println("\n=== ALUMNO CON MAYOR EDAD ===");
        System.out.println(obtenerAlumnoMayor(alumnos));

        //6. Obtener el primer alumno
        System.out.println("\n=== PRIMER ALUMNO ===");
        System.out.println(obtenerPrimerAlumno(alumnos));

        //7. Obtener los alumnos cuyos cursos terminan en 'a'
        System.out.println("\n=== ALUMNOS CUYOS CURSOS TERMINAN EN A ===");
        Alumno.printTable(obtenerAlumnosCuyoCursoTerminaEnA(alumnos));

        //8. Obtener los alumnos cuyos cursos contienen la letra 'y'
        System.out.println("\n=== ALUMNOS CUYOS CURSOS CONTIENEN LA LETRA Y ===");
        Alumno.printTable(obtenerAlumnosCuyoCursoContienenY(alumnos));

        //9. Obtener los alumnos cuyos nombres es mayor a 6 caracteres
        System.out.println("\n=== ALUMNOS CUYOS NOMBRES SON MAYORES A 6 CARACTERES ===");
        Alumno.printTable(obtenerAlumnosCuyoNombreEsMayorA6(alumnos));

    }

    /**
     * Devuelve la lista de alumnos formateada en tabla.
     * @param alumnoList Lista de alumnos.
     */
    private static void listarAlumnos(List<Alumno> alumnoList) {
        Alumno.printTable(alumnoList);
    }


    private static List<Alumno> obtenerAlumnosPorIniciales(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .filter(a -> a.getNombre().startsWith("L") || a.getNombre().startsWith("S"))
                .toList();
    }

    private static int obtenerNumeroAlumnos(List<Alumno> alumnoList) {
        return alumnoList.size();
    }

    private static Optional<Alumno> obtenerAlumnoMenor(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .min((o1, o2) -> o1.getEdad() - o2.getEdad());
    }

    private static Optional<Alumno> obtenerAlumnoMayor(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .max((o1, o2) -> o1.getEdad() - o2.getEdad());
    }

    private static Optional<Alumno> obtenerPrimerAlumno(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .findFirst();
    }

    private static List<Alumno> obtenerAlumnosCuyoCursoTerminaEnA(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .filter(alumno -> alumno.getNombreCurso().endsWith("a"))
                .toList();
    }

    private static List<Alumno> obtenerAlumnosCuyoCursoContienenY(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .filter(alumno -> alumno.getNombreCurso().contains("y"))
                .toList();
    }

    private static List<Alumno> obtenerAlumnosCuyoNombreEsMayorA6(List<Alumno> alumnoList) {
        return alumnoList.stream()
                .filter(alumno -> alumno.getNombre().length() > 6)
                .toList();
    }

}
