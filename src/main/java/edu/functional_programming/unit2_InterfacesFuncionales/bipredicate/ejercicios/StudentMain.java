package edu.functional_programming.unit2_InterfacesFuncionales.bipredicate.ejercicios;

import edu.functional_programming.unit2_InterfacesFuncionales.predicate.ejercicios.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Se requiere obtener un reporte con todos los empleados qque cumplan con alguno de estos conjuntos de criterios:
 * <p>1. 25 años en adelante y que esten en el departamento de Ventas.</p>
 * <p>2. 25 años en adelante y que esten en el departamento de Mostrador.</p>
 */
public class StudentMain {

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Saul", 40, 2800, "Ventas"),
                new Student("Felipe", 39, 1800, "Cobranzas"),
                new Student("Alejandra", 41, 700, "Arauca"),
                new Student("Leidy", 30, 1700, "Ventas"),
                new Student("Oswaldo", 51, 6700, "Mostrador"),
                new Student("Alvaro", 65, 250, "Mostrador")
        );

        EvaluatorBi evaluatorBi = new EvaluatorBi();

        BiPredicate<Integer, String> primerCriterio = (edad, departamento) -> (edad >= 25) && (departamento.equals("Ventas"));
        BiPredicate<Integer, String> segudoCriterio = (edad, departamento) -> (edad >= 25) && (departamento.equals("Mostrador"));

        BiPredicate<Integer, String> criterio = primerCriterio.or(segudoCriterio);

        System.out.println("Estudiantes de mostrador o ventas mayores de 25 años.");
        List<Student> listaActualizada =  evaluatorBi.toValue(studentList, criterio);

        for (Student student : listaActualizada) {
            System.out.println("Nombre: " + student.getName() + ", Edad: " + student.getAge() + " años, Departamento: " + student.getDepartment());
        }

    }

}
