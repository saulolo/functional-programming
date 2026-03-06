package edu.functional_programming.unit2_InterfacesFuncionales.biconsumer.ejercicios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BiConsumerWithMapExample {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        String[][] array = {{"Saul", "Colombia"}, {"Felipe", "USA"}, {"Alejandra", "Nigeria"}, {"Leidy", "Dubai"}};

        for (int i = 0; i < array.length; i++) {
            map.put(array[i][0], array[i][1]);
        }

        System.out.println("=== IMPRESIÓN TRADICIONAL DE UN MAP (ANTES DE JAVA 8) ===");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println("Clave: " + entry.getKey() + " Valor: " + entry.getValue());
            }
        }


        System.out.println("\n=== IMPRESIÓN MODERNA CON BICONSUMER (forEach) ===");
        map.forEach((key, value) -> {
            System.out.println("Clave => " + key + "\tValor => " + value);
        });

    }
}
