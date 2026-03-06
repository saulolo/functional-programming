package edu.functional_programming.unit3_metodosReferenciados;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Manager extends Person {

    public Manager(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void greet() {
        System.out.println("Hola soy el Gerente.");
    }
}
