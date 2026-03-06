package edu.functional_programming.unit2_InterfacesFuncionales.function.ejercicios;

public class Comensal {

    private String name;
    private double order;
    private int table;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOrder() {
        return order;
    }

    public void setOrder(double order) {
        this.order = order;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Comensal(String name, double order, int table) {
        this.name = name;
        this.order = order;
        this.table = table;


    }
}
