package edu.functional_programming.unit2_InterfacesFuncionales.consumer.ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StudentUniversityMain {

    public static void main(String[] args) {

        List<StudentUniversity> studentList = Arrays.asList(
                new StudentUniversity("Saul", 5),
                new StudentUniversity("Felipe", 4),
                new StudentUniversity("Alejandra", 3),
                new StudentUniversity("Leidy", 2.5),
                new StudentUniversity("Oswaldo", 4.5),
                new StudentUniversity("Alvaro", 1.0)
        );

        StudentOperation operation = new StudentOperation();

/*        //Imprimiendo los estudiantes con Consumer
        Consumer<StudentUniversity> con1 = x -> System.out.println(
                "Nombre: " + x.getName() + ", Nota: " + x.getRating() );

        System.out.println("=== Lista Original de estudiantes ===");
        operation.acceptAll(studentList, con1);

        //Hacer que la calificación de cada estudiante se incremente en un 15%
        Consumer<StudentUniversity> con2 = x -> x.setRating(x.getRating() * 1.15);
        operation.acceptAll(studentList, con2);

        System.out.println("\n");

        System.out.println("=== Lista de estudiantes con incremento en las notas ===");
        operation.acceptAll(studentList, con1);*/

        System.out.println("=================================================================================");

        System.out.println("=== PROBANDO EL MÉTODO ANDTHEN ===");

        //Imprimiendo los estudiantes con Consumer
        Consumer<StudentUniversity> con1 = x -> System.out.println(
                "Nombre: " + x.getName() + ", Nota: " + x.getRating());

        System.out.println("=== Lista Original de estudiantes ===");
        operation.acceptAll(studentList, con1);

        System.out.println("\n");


        //Hacer que la calificación de cada estudiante se incremente en un 15%
        Consumer<StudentUniversity> con2 = x -> x.setRating(x.getRating() * 1.15);
        operation.acceptAll(studentList, con2);

        System.out.println("=== Lista de estudiantes con incremento en las notas ===");
        //Utilizo el el metodo andThen ==> LLamo al con2 para que haga el incremento y despues le paso el con1 para llamar la lista actualizada
        Consumer<StudentUniversity> con3 = con2.andThen(con1);
        operation.acceptAll(studentList, con3);

    }

}
