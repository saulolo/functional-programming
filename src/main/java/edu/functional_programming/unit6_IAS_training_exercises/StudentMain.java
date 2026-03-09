package edu.functional_programming.unit6_IAS_training_exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Ejercicios de Programación funcional con Java Streams.
 * @author Saul Echeverri
 */
public class StudentMain {

    public static void main(String[] args) {

        List<Student> students = StudentDataset.getStudentFromDB();

        System.out.println("=== NIVEL 1. OPERACIONES BÁSICAS ===");
        //1. Obtener todos los estudiantes de grado 11.
        System.out.println("Ejercicio 1 => Estudiantes de Grado 11: ");
        List<Student> grade11 = getStudentsFromGrade11(students);
        Student.printTable(grade11);

        //2. Obtener la lista de nombres de todos los estudiantes.
        System.out.println("\nEjercicio 2 => Nombres de los estudiantes: ");
        List<String> studentsNames = getStudentsFromFirstName(students);
        System.out.println(studentsNames);
        //studentsNames.forEach(System.out::println);

        //3. Obtener todos los estuciantes mayores de 15 años.
        System.out.println("\nEjercicio 3 => Estudiantes mayores a 15 años: ");
        List<Student> olderStudents = getStudentsOlderThan15(students);
        Student.printTable(olderStudents);


        System.out.println("=== NIVEL 2. TRANSFORMACIÓN Y ORDENAMIENTO ===");
        //1. Listar todos los estudiantes ordenados por edad.
        System.out.println("\nEjercicio 1 => Edad de los estudiantes de menor a mayor: ");
        List<Student> studentsByAges = getStudentsSortedByAge(students);
        Student.printTable(studentsByAges);

        //2. Obtener todos los grupos existentes sin repetir.
        System.out.println("\nEjercicio 2 => Grupos de estudiantes sin repetir: ");
        List<String> distinctGroups = getStudentsByGroupWithoutRepeat(students);
        distinctGroups.forEach(System.out::println);


        System.out.println("=== NIVEL 3. OPERACIONES DE AGREGACIÓN ===");
        //1. Calcular el promedio de edad de todos los estudiantes.
        System.out.println("\nEjercicio 1 => Promedio de edad de los Estudiantes: ");
        double averageAge = getStudentsAverageAge(students);
        System.out.printf("Promedio: %.1f años%n", averageAge);

        //2. Calcular la cantidad de estudiantes por grado.
        System.out.println("\nEjercicio 2 => Cantidad de estudiantes por grado: ");
        Map<Integer, Long> studentsByGrade = countStudentsByGrade(students);
        studentsByGrade.forEach((grade, count) ->
                System.out.println("Grado " + grade + ": " + count + " estudiantes"));

        //3. Calcular cuántos estudiantes hay por grupo étnico.
        System.out.println("\nEjercicio 3 => Cantidad de estudiantes por grup etnico: ");
        Map<String, Long> studentsByEthnicGroup = countStudentsByEthnicGroup(students);
        studentsByEthnicGroup.forEach((ethnicGroup, count) ->
                System.out.println("Grupo Étnico " + ethnicGroup + ": " + count + " estudiantes"));


        System.out.println("=== NIVEL 4. AGRUPACIONES ===");
        // Ejercicio 1: Agrupar estudiantes por grado
        System.out.println("\nEjercicio 1 => Estudiantes agrupados por grado:");
        Map<Integer, List<Student>> studentsStructureByGrade = groupStudentsByGrade(students);
        studentsStructureByGrade.forEach((grade, studentList) -> {
            System.out.println("\nGrado " + grade + ":");
            Student.printTable(studentList);
        });

        // Ejercicio 2: Agrupar por grado y luego por género
        System.out.println("\nEjercicio 2 => Estudiantes agrupados por grado y género:");
        Map<Integer, Map<String, List<Student>>> studentsByGradeAndGender = groupStudentsByGradeAndGender(students);
        studentsByGradeAndGender.forEach((grade, genderMap) -> {
            System.out.println("\nGrado " + grade + ":");
            genderMap.forEach((gender, studentList) -> {
                System.out.println("\nGénero: " + gender);
                Student.printTable(studentList);
            });
        });


        System.out.println("=== NIVEL 5. TRANSFORMACIONES AVANZADAS ===");
        // Ejercicio 1:  Obtener los nombres de los estudiantes agrupados por grado.
        System.out.println("\nEjercicio 1 => Nombres de estudiantes agrupados por grado:");
        Map<Integer, List<String>> namesByGrade = getStudentNamesByGrade(students);
        namesByGrade.forEach((grade, names) ->
                System.out.println("Grado " + grade + ": " + names));

        // Ejercicio 2: Obtener el estudiante más viejo por grado
        System.out.println("\nEjercicio 2 => Estudiante más viejo por grado:");
        Map<Integer, Optional<Student>> oldestByGrade = getOldestStudentByGrade(students);
        oldestByGrade.forEach((grade, student) ->
                System.out.println("Grado " + grade + ": " + student.map(Student::getFirstName).orElse("N/A"))
        );


        System.out.println("=== NIVEL 6. PARTICIONES ===");
        // Ejercicio 1: Separar estudiantes mayores y menores de 15 años
        System.out.println("\nEjercicio 1 => Estudiantes separados por edad (mayor/menor a 15):");
        Map<Boolean, List<Student>> partitionedStudents = partitionStudentsByAge(students);
        System.out.println("\nMayores de 15 años:");
        Student.printTable(partitionedStudents.get(true));

        System.out.println("\nMenores o iguales a 15 años:");
        Student.printTable(partitionedStudents.get(false));

        System.out.println("=== NIVEL 7. BÚSQUEDAS ===");
        // Ejercicio 1: Encontrar el primer estudiante del grado 11
        System.out.println("\nEjercicio 1 => Primer estudiante del grado 11:");
        Optional<Student> firstStudent = getFirstStudentFromGrade11(students);
        firstStudent.ifPresentOrElse(
                student -> Student.printTable(List.of(student)),
                () -> System.out.println("No se encontró ningún estudiante de grado 11.")
        );

        // Ejercicio 2: Verificar si existe algún estudiante indígena
        System.out.println("\nEjercicio 2 => ¿Existe algún estudiante indígena?");
        boolean hasIndigenous = hasIndigenousStudent(students);
        System.out.println("Resultado: " + hasIndigenous);

        // Ejercicio 3: Verificar si todos tienen más de 5 años
        System.out.println("\nEjercicio 3 => ¿Todos los estudiantes tienen más de 5 años?");
        boolean allOlderThan5 = allStudentsOlderThan5(students);
        System.out.println("Resultado: " + allOlderThan5);


        System.out.println("=== NIVEL 8. OPERACIONES MÁS AVANZADAS ===");
        // Ejercicio 1: Obtener los 10 estudiantes más jóvenes
        System.out.println("\nEjercicio 1 => Los 10 estudiantes más jóvenes:");
        List<Student> top10Youngest = getTop10YoungestStudents(students);
        Student.printTable(top10Youngest);

        // Ejercicio 2: Obtener la distribución porcentual por grupo étnico
        System.out.println("\nEjercicio 2 => Distribución porcentual por grupo étnico:");
        Map<String, Double> ethnicPercentage = getEthnicGroupPercentage(students);
        ethnicPercentage.forEach((ethnic, percentage) ->
                System.out.printf("%-10s: %.1f%%%n", ethnic, percentage));

        // Ejercicio 3: Promedio de edad por grado
        System.out.println("\nEjercicio 3 => Promedio de edad por grado:");
        Map<Integer, Double> avgAgeByGrade = getAverageAgeByGrade(students);
        avgAgeByGrade.forEach((grade, avg) ->
                System.out.printf("Grado %-3d: %.1f años%n", grade, avg));

        // Ejercicio 4: Obtener el número total de estudiantes por género en cada grado
        System.out.println("\nEjercicio 4 => Total de estudiantes por género en cada grado:");
        Map<Integer, Map<String, Long>> countByGradeAndGender = countStudentsByGradeAndGender(students);
        countByGradeAndGender.forEach((grade, genderMap) -> {
            System.out.println("Grado " + grade + ":");
            genderMap.forEach((gender, count) ->
                    System.out.println("   " + gender + ": " + count + " estudiantes"));
        });


        System.out.println("=== NIVEL 9. EJERCICIOS AVANZADOS ===");
        // Ejercicio 1: Obtener el grado con más estudiantes
        System.out.println("\nEjercicio 1 => Grado con mayor cantidad de estudiantes:");
        getGradeWithMostStudents(students).ifPresentOrElse(
                entry -> System.out.println("Grado " + entry.getKey() + " con " + entry.getValue() + " estudiantes."),
                () -> System.out.println("No se encontró ningún grado.")
        );

        // Ejercicio 2: Obtener el grupo étnico más común
        System.out.println("\nEjercicio 2 => Grupo étnico más común:");
        getMostCommonEthnicGroup(students).ifPresentOrElse(
                entry -> System.out.println(entry.getKey() + " con " + entry.getValue() + " estudiantes."),
                () -> System.out.println("No se encontró ningún grupo étnico.")
        );

        // Ejercicio 3: Mapa con ID como llave
        System.out.println("\nEjercicio 3 => Mapa de estudiantes por ID:");
        Map<Long, Student> studentsById = getStudentsById(students);
        studentsById.forEach((id, student) ->
                System.out.println("ID " + id + " → " + student.getFirstName() + " " + student.getLastName())
        );

        // Ejercicio 4: Agrupar por rango de edad
        System.out.println("\nEjercicio 4 => Estudiantes agrupados por rango de edad:");
        Map<String, List<Student>> studentsByAgeRange = groupStudentsByAgeRange(students);
        studentsByAgeRange.forEach((range, studentList) -> {
            System.out.println("\nRango " + range + " años:");
            Student.printTable(studentList);
        });


    }

    /**
     * Retorna una lista con los nombres (firstName) de todos los estudiantes.
     * @param students Lista de estudiantes.
     * @return Lista de nombres de los estudiantes.
     */
    public static List<Student> getStudentsFromGrade11(List<Student> students) {
        return students.stream()
                .filter(s -> s.getGrade() == 11)
                .toList();
    }

    /**
     * Retorna una lista con los nombres (firstName) de todos los estudiantes.
     * @param students Lista de estudiantes.
     * @return Lista de nombres de los estudiantes.
     */
    public static List<String> getStudentsFromFirstName(List<Student> students) {
        return students.stream()
                .map(Student::getFirstName)
                .toList();
    }

    /**
     * Retorna los estudiantes cuya edad sea mayor a 15 años.
     * @param students Lista de estudiantes a filtrar.
     * @return Lista de estudiantes mayores de 15 años.
     */
    public static List<Student> getStudentsOlderThan15(List<Student> students) {
        return students.stream()
                .filter(s -> s.getAge() > 15)
                .toList();
    }

    /**
     * Retorna los estudiantes ordenados de menor a mayor edad.
     * @param students Lista de estudiantes a ordenar.
     * @return Lista de estudiantes ordenada por edad ascendente.
     */
    public static List<Student> getStudentsSortedByAge(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .toList();
    }

    /**
     * Retorna una lista con todos los grupos existentes sin duplicados.
     * @param students Lista de estudiantes.
     * @return Lista de grupos únicos.
     */
    public static List<String> getStudentsByGroupWithoutRepeat(List<Student> students) {
        return students.stream()
                .map(Student::getGroup)
                .distinct()
                .toList();
    }

    /**
     * Calcula el promedio de edad de todos los estudiantes.
     * @param students Lista de estudiantes.
     * @return Promedio de edad, o 0.0 si la lista está vacía.
     */
    public static double getStudentsAverageAge(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    /**
     * Retorna un mapa con la cantidad de estudiantes por grado.
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y cantidad de estudiantes como valor.
     */
    public static Map<Integer, Long> countStudentsByGrade(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
    }

    /**
     * Retorna un mapa con la cantidad de estudiantes por grupo étnico.
     * @param students Lista de estudiantes.
     * @return Mapa con grupo étnico como llave y cantidad de estudiantes como valor.
     */
    public static Map<String, Long> countStudentsByEthnicGroup(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getEthnicGroup,
                        Collectors.counting()
                ));
    }

    /**
     * Agrupa los estudiantes por grado.
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y lista de estudiantes como valor.
     */
    public static Map<Integer, List<Student>> groupStudentsByGrade(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
    }


    /**
     * Agrupa los estudiantes por grado y luego por género.
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y un mapa de género->estudiantes como valor.
     */
    public static Map<Integer, Map<String, List<Student>>> groupStudentsByGradeAndGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.groupingBy(Student::getGender)
                ));
    }

    /**
     * Retorna un mapa con los nombres de los estudiantes agrupados por grado.
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y lista de nombres como valor.
     */
    public static Map<Integer, List<String>> getStudentNamesByGrade(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(
                                Student::getFirstName,
                                Collectors.toList()
                        )
                ));
    }

    /**
     * Retorna el estudiante de mayor edad por cada grado.
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y el estudiante más viejo como valor.
     */
    public static Map<Integer, Optional<Student>> getOldestStudentByGrade(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.maxBy(Comparator.comparing(Student::getAge))
                ));
    }

    /**
     * Separa los estudiantes en dos grupos: mayores y menores/iguales a 15 años.
     * @param students Lista de estudiantes.
     * @return Mapa con true para mayores de 15 y false para menores o iguales.
     */
    public static Map<Boolean, List<Student>> partitionStudentsByAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 15));
    }

    /**
     * Retorna el primer estudiante encontrado en el grado 11.
     * @param students Lista de estudiantes.
     * @return Optional con el primer estudiante de grado 11, o vacío si no existe.
     */
    public static Optional<Student> getFirstStudentFromGrade11(List<Student> students) {
        return students.stream()
                .filter(s -> s.getGrade() == 11)
                .findFirst();
    }

    /**
     * Verifica si existe al menos un estudiante de grupo étnico indígena.
     * @param students Lista de estudiantes.
     * @return true si existe al menos un estudiante indígena, false en caso contrario.
     */
    public static boolean hasIndigenousStudent(List<Student> students) {
        return students.stream()
                .anyMatch(s -> s.getEthnicGroup().equalsIgnoreCase("Indigena"));
    }

    /**
     * Verifica si todos los estudiantes tienen más de 5 años.
     * @param students Lista de estudiantes.
     * @return true si todos los estudiantes son mayores de 5 años, false en caso contrario.
     */
    public static boolean allStudentsOlderThan5(List<Student> students) {
        return students.stream()
                .allMatch(s -> s.getAge() > 5);
    }

    /**
     * Retorna los 10 estudiantes más jóvenes ordenados por edad ascendente.
     * @param students Lista de estudiantes.
     * @return Lista con los 10 estudiantes de menor edad.
     */
    public static List<Student> getTop10YoungestStudents(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .limit(10)
                .toList();
    }

    /**
     * Calcula la distribución porcentual de estudiantes por grupo étnico.
     * @param students Lista de estudiantes.
     * @return Mapa con grupo étnico como llave y porcentaje como valor.
     */
    public static Map<String, Double> getEthnicGroupPercentage(List<Student> students) {
        long total = students.size();
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getEthnicGroup,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / total
                ));
    }


    /**
     * Calcula el promedio de edad de los estudiantes por grado.
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y promedio de edad como valor.
     */
    public static Map<Integer, Double> getAverageAgeByGrade(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingInt(Student::getAge)
                ));
    }

    /**
     * Retorna el total de estudiantes por género en cada grado.
     *
     * @param students Lista de estudiantes.
     * @return Mapa con grado como llave y un mapa de género->cantidad como valor.
     */
    public static Map<Integer, Map<String, Long>> countStudentsByGradeAndGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.groupingBy(
                                Student::getGender,
                                Collectors.counting()
                        )
                ));
    }

    /**
     * Retorna el grado con mayor cantidad de estudiantes.
     *
     * @param students Lista de estudiantes.
     * @return Optional con la entrada (grado, cantidad) de mayor cantidad.
     */
    public static Optional<Map.Entry<Integer, Long>> getGradeWithMostStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    /**
     * Retorna el grupo étnico con mayor cantidad de estudiantes.
     *
     * @param students Lista de estudiantes.
     * @return Optional con la entrada (etnia, cantidad) de mayor cantidad.
     */
    public static Optional<Map.Entry<String, Long>> getMostCommonEthnicGroup(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getEthnicGroup,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    /**
     * Retorna un mapa con el ID de cada estudiante como llave.
     * @param students Lista de estudiantes.
     * @return Mapa con ID como llave y estudiante como valor.
     */
    public static Map<Long, Student> getStudentsById(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        student -> student
                ));
    }

    /**
     * Determina el rango de edad al que pertenece una edad dada.
     *
     * @param age Edad del estudiante.
     * @return Rango de edad como String ("6-10", "11-14", "15-18").
     */
    private static String getAgeRange(int age) {
        if (age >= 6 && age <= 10)  return "6-10";
        if (age >= 11 && age <= 14) return "11-14";
        if (age >= 15 && age <= 18) return "15-18";
        return "Otro";
    }

    /**
     * Agrupa los estudiantes según su rango de edad.
     *
     * @param students Lista de estudiantes.
     * @return Mapa con rango de edad como llave y lista de estudiantes como valor.
     */
    public static Map<String, List<Student>> groupStudentsByAgeRange(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        s -> getAgeRange(s.getAge())
                ));
    }

}
