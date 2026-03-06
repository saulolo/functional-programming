package edu.functional_programming.unit4_streams.ejercicio2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Automobile {

    String marca;
    String modelo;
    double costo;


    @Override
    public String toString() {
        return String.format(
                "%-10s | %-10s | %-10.2f",
                marca, modelo, costo
        );
    }

}
