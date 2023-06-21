package org.example;

public class Car
{
    private String name;
    private double cost;
    private String targa;
    private int number;


    public Car(String name, double cost, String targa, int number) {
        this.name = name;
        this.cost = cost;
        this.targa = targa;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost= cost;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
