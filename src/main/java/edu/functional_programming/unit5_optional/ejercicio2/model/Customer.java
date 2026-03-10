package edu.functional_programming.unit5_optional.ejercicio2.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    Long id;
    String name;
    String lastName;
    String address;
    String phone;


    @Override
    public String toString() {
        return String.format(
                "%-3d | %-18s | %-10s | %-10s | %-10s",
                id, name, lastName, address, phone
        );
    }

}
