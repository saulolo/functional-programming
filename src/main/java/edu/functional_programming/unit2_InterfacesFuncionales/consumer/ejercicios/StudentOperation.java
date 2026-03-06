package edu.functional_programming.unit2_InterfacesFuncionales.consumer.ejercicios;

import java.util.List;
import java.util.function.Consumer;

public class StudentOperation {

    public void acceptAll(List<StudentUniversity> students, Consumer<StudentUniversity> consumer) {

        for (StudentUniversity student : students) {
            consumer.accept(student);
        }

    }
}
