package edu.functional_programming.unit2_InterfacesFuncionales.function.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DatosComensales {

    public static void main(String[] args) {

        List<Comensal> comensals = Arrays.asList(
                new Comensal("Felipe", 233.0, 24),
                new Comensal("Alejandra", 153.0, 10),
                new Comensal("Leidy", 753.0, 16),
                new Comensal("Diego", 53.2, 19));


        List<Object> tables  = getDatosComensales(comensals, x -> x.getTable());

        for (Object table : tables) {
            System.out.println("Mesa #: " + table);
        }

    }


    public static List<Object> getDatosComensales(List<Comensal> comensalList, Function<Comensal, Object> fun) {

        List<Object> listaDatos = new ArrayList<>();
        for (Comensal comensal : comensalList) {
            listaDatos.add(fun.apply(comensal));
        }

        return listaDatos;
    }

}
