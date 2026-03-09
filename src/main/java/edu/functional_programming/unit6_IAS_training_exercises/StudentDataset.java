package edu.functional_programming.unit6_IAS_training_exercises;

import java.util.Arrays;
import java.util.List;

public class StudentDataset {

    public static List<Student> getStudentFromDB() {

        return Arrays.asList(
                new Student(1L,  "Ana",     "Gomez",    12, "Female", 6,  "6-A",  "Mestizo"),
                new Student(2L,  "Carlos",  "Perez",    16, "Male",   11, "11-B", "Mestizo"),
                new Student(3L,  "Laura",   "Torres",   17, "Female", 11, "11-A", "Afro"),
                new Student(4L,  "Miguel",  "Rios",     15, "Male",   10, "10-C", "Indigena"),
                new Student(5L,  "Sofia",   "Vargas",   16, "Female", 11, "11-A", "Mestizo"),
                new Student(6L,  "Juan",    "Lopez",    14, "Male",   9,  "9-B",  "Mestizo"),
                new Student(7L,  "Camila",  "Herrera",  17, "Female", 11, "11-B", "Afro"),
                new Student(8L,  "Andres",  "Castro",   13, "Male",   8,  "8-A",  "Mestizo"),
                new Student(9L,  "Valeria", "Mora",     16, "Female", 11, "11-C", "Indigena"),
                new Student(10L, "Pedro",   "Jimenez",  15, "Male",   10, "10-A", "Mestizo"),
                new Student(11L, "Saul",   "Echeverri",  17, "Male",   11, "11-A", "Mestizo"),
                new Student(12L, "Felipe",   "Vasquez",  13, "Male",   11, "11-B", "Indigena"),
                new Student(13L, "Alejandra",   "Arenas",  14, "Female",   10, "10-A", "Afro"),
                new Student(14L, "Leidy",   "Zapata",  14, "Female",   9, "9-B", "Mestizo"),
                new Student(15L, "Diego",   "Martinez",  12, "Male",   8, "8-B", "Afro")
        );
    }

}
