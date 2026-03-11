package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio1_Veterinaria;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * En una clínica veterinaria se registran las atenciones realizadas a diferentes pacientes durante cada día. Cada
 * atención está representada por los siguientes datos: id, nombreMascota, especieMascota, nombreTutor, servicio, costo.
 * A partir del último día que abrió la clínica, se pudo registrar la siguiente lista de atenciones (Lista instanciada):
 * A partir de estos datos, utilizando lambdas y streams, resuelve las siguientes consignas:
 * <p>1. Obtener una lista con los nombres de las mascotas que tuvieron como servicio una CONSULTA, ordenadas alfabéticamente.<p/>
 * <p>2. Calcular el monto total facturado en el día.</p>
 * <p>3. Obtener la cantidad de atenciones realizadas por cada tipo de mascota (ejemplo: PERRO —+ 5, GATO —i 3, etc.).</p>
 * <p>4. Mostrar por pantalla los nombres de los tutores cuyas mascotas tuvieron una atención con costo mayor a $15.000,
 * sin repetir nombres.<p/>
 * <p>Punto Extra: Determinar cuál fue el servicio más solicitado del día.<p/>
 * @author Saul Echeverri
 */
public class AttentionMain {

    public static void main(String[] args) {

        List<Attention> attentionList = AttentionDataset.getAttentionFromDB();

        System.out.println("=== ATENCIÓN VETERINARIA ===");

        System.out.println("Atenciones realizadas: ");
        Attention.printTable(attentionList);

        System.out.println("\n1. Mascotas con el servicio de CONSULTA: ");
        List<String> service= getSortedPetNamesByConsultation(attentionList);
        service.forEach(System.out::println);

        System.out.println("\n============================================");

        System.out.println("\n2. Monto total del dia: ");
        int total = getTotalRevenue(attentionList);
        System.out.printf("$%,d%n",  total);

        System.out.println("\n============================================");

        System.out.println("\n3. Total atencion por especie: ");
        Map<String, Long> countSpecie = getAttentionCountBySpecies(attentionList);
        countSpecie.forEach((e, c) -> System.out.println(e + " --> " + " " + c));

        System.out.println("\n============================================");

        System.out.println("\n4. Tutores con servicios mayores a $15.000: ");
        List<String> tutorName= getDistinctTutorsByMinCost(attentionList);
        tutorName.forEach(System.out::println);

        System.out.println("\n============================================");

        System.out.println("\nPunto extra: Servicio más solicitado del día:");
        Optional<String> mostRequested = getMostRequestedService(attentionList);
        mostRequested.ifPresentOrElse(
                serviceMost -> System.out.println("Servicio más solicitado: " + serviceMost),
                () -> System.out.println("No se encontró ningún servicio.")
        );

    }

    /**
     * Retorna una lista en orden ascendente con los nombres de las mascotas cuyo servicio fue el de Consulta.
     * @param attentions Lista de atenciones.
     * @return Lista de los nombres de las mascotas.
     */
    public static List<String> getSortedPetNamesByConsultation(List<Attention> attentions) {
        return attentions.stream()
                .filter(att -> att.getService().equalsIgnoreCase("Consulta"))
                .map(Attention::getPetName)
                .sorted()
                .toList();
    }

    /**
     * Calcula el monto total facturado en el día sumando el costo de todas las atenciones.
     * @param attentions Lista de atenciones.
     * @return Monto total facturado.
     */
    public static Integer getTotalRevenue(List<Attention> attentions) {
        return attentions.stream()
                .mapToInt(Attention::getCost)
                .sum();
    }

    /**
     * Retorna un mapa con la cantidad de atenciones realizadas por cada tipo de mascota (especie).
     * @param attentions Lista de atenciones.
     * @return Mapa donde la clave es la especie y el valor la cantidad de atenciones.
     */
    public static Map<String, Long> getAttentionCountBySpecies(List<Attention> attentions) {
        return attentions.stream()
                .collect(Collectors.groupingBy(
                        Attention::getSpecies,
                        Collectors.counting()
                ));
    }


    /**
     * Retorna una lista ordenada con los nombres de tutores cuyas mascotas tuvieron una atención de costo superior a $ 15.000.
     * Los nombres estarán sin repetir.
     * @param attentions Lista de atenciones.
     * @return Lista de nombres de tutores.
     */
    public static List<String> getDistinctTutorsByMinCost(List<Attention> attentions) {
        return attentions.stream()
                .filter(att -> att.getCost() > 15_000)
                .map(Attention::getTutorName)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Determina el servicio más solicitado del día.
     * @param attentions Lista de atenciones.
     * @return Optional con el nombre del servicio más solicitado.
     */
    public static Optional<String> getMostRequestedService(List<Attention> attentions) {
        return attentions.stream()
                .collect(Collectors.groupingBy(
                        Attention::getService,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

}
