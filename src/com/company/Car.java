package com.company;

public class Car extends Vehicle{
    //constructores de Vehicle agregando doors para las puertas
    private int doors;

    public Car(String brand, String model, double price, int doors) {
        super(brand, model, price);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }
}
