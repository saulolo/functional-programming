package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.service.impl;

import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Category;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.model.Toy;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.repository.ToyRepository;
import edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio3_Jugueteria.service.interfaces.IToyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ToyServiceImpl implements IToyService {

    private final ToyRepository toyRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getPopularToyNames() {
        return toyRepository.getToysFromDB().stream()
                .filter(t -> t.getStock() > 0 && t.getSalesLast30Days() > 50)
                .sorted((t1, t2) -> Integer.compare(t2.getSalesLast30Days(), t1.getSalesLast30Days()))
                .map(Toy::getName)
                .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getEducationalToysAveragePrice() {
        return toyRepository.getToysFromDB().stream()
                .filter(t -> t.getCategory().equals(Category.EDUCATIONAL))
                .mapToInt(Toy::getPrice)
                .average()
                .orElse(0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Long> getToyCountByCategory() {
        return toyRepository.getToysFromDB().stream()
                .collect(Collectors.groupingBy(
                        t -> t.getCategory().toString(),
                        Collectors.counting()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Toy> getMostExpensiveBoardGameToy() {
        return toyRepository.getToysFromDB().stream()
                .filter(t -> t.getCategory().equals(Category.BOARD_GAME))
                .max(Comparator.comparingInt(Toy::getPrice));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> getBrandOfMostExpensiveBoardGameToyLowercase() {
        return getMostExpensiveBoardGameToy()
                .map(Toy::getBrand)
                .filter(brand -> !brand.isBlank())
                .map(String::toLowerCase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Toy> getTop5ByScore() {
        return toyRepository.getToysFromDB().stream()
                .filter(toy -> toy.getScore() != null)
                .sorted(Comparator.comparingDouble(Toy::getScore).reversed())
                .limit(5)
                .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> getAllTagsLowercase() {
        return toyRepository.getToysFromDB().stream()
                .flatMap(toy -> toy.getTags().stream())
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Double> getTotalInventoryValueByCategory() {
        return toyRepository.getToysFromDB().stream()
                .collect(
                        Collectors.groupingBy(
                                toy -> toy.getCategory().toString(),
                                Collectors.summingDouble(toy -> toy.getPrice() * toy.getStock())
                        ));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getRestockAlerts() {
        return toyRepository.getToysFromDB().stream()
                .filter(toy -> toy.getStock() < 5)
                .map(toy -> String.format("Reponer: %s (stock: %d)", toy.getName(), toy.getStock()))
                .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Toy> findToyByExactName(String name) {
        return toyRepository.getToysFromDB().stream()
                .filter(toy -> toy.getName().equals(name))
                .findFirst();
    }

}
