package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio1_Veterinaria;

import java.util.List;

public class AttentionDataset {

    public static List<Attention> getAttentionFromDB() {
        return List.of(
                new Attention(1L, "Max", "Perro", "Luis", "Consulta", 12_000),
                new Attention(2L, "Milo", "Gato", "Carla", "Vacunacion", 18_000),
                new Attention(3L, "Lola", "Perro", "Marcos", "Cirugia", 55_000),
                new Attention(4L, "Nina", "Conejo", "Lucia", "Control", 9_000),
                new Attention(5L, "Simba", "Gato", "Carla", "Consulta", 13_000),
                new Attention(6L, "Rocky", "Perro", "Pedro", "Vacunacion", 17_000),
                new Attention(7L, "Kiwi", "Ave", "Sofia", "Consulta", 11_000),
                new Attention(8L, "Toby", "Perro", "Luis", "Control", 10_000),
                new Attention(9L, "Mora", "Gato", "Valeria", "Cirugia", 60_000),
                new Attention(10L, "Bruno", "Perro", "Marcos", "Consulta", 14_000)
        );
    }

}
