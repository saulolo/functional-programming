package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria;

import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Toy;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.repository.ToyRepository;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.service.impl.ToyServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public class TestToyMain {

    public static void main(String[] args) {

        //Lista de juguetes
        //ToyRepository toyRepository = new ToyRepository();
        //ToyServiceImpl toyService = new ToyServiceImpl(toyRepository);

        //System.out.println("=== LISTA COMPLETA JUGUETES ===");
        //List<Toy> toys = toyRepository.getToysFromDB();
        //Toy.printTable(toys);

        //System.out.println("\n=== NOMBRES FILTRADOS ===");
        //1 . Obtener los nombres de los juguetes que: tengan stock > 0 y hayan vendido más de 50 unidades en los
        //últimos 30 días. Deben estar ordenados de mayor a menor según ventas.
        //List<String> names = toyService.getPopularToyNames();
        //names.forEach(System.out::println);

    }

}
