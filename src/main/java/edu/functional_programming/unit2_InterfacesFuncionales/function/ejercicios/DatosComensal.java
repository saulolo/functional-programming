package edu.functional_programming.unit2_InterfacesFuncionales.function.ejercicios;

import java.util.function.Function;

public class DatosComensal {

    public static void main(String[] args) {

        Comensal comen1= new Comensal("Saul", 156.4, 13);

        //Nombre
        //String comensalName = (String) getDataComesal(comen1, Comensal::getName);
        String comensalName = (String) getDataComesal(comen1, x -> x.getName());

        System.out.println("Nombre del comensal: " + comensalName);

        //Mesa
        int comensalTable = (int) getDataComesal(comen1, x -> x.getTable());
        System.out.println("la mesa es: " + comensalTable);

    }




    public static Object getDataComesal(Comensal comensal, Function<Comensal, Object>function) {

        return function.apply(comensal);

    }
}
