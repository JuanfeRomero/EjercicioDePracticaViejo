package com.company;

abstract class Vehicle implements ICarDealership {
    //clase padre con los metodos para conseguir la marca, el modelo y el precio.
    private String brand;
    private String model;
    private double price;

    public Vehicle(String brand, String model, double price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
