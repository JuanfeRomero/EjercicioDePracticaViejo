package com.company;

public class Motorcycle extends Vehicle{
    //constructores de vehicle agregando displacement para la cilindrada
    public String displacement;

        public Motorcycle(String brand, String model, double price, String displacement){
            super(brand, model, price);
            this.displacement = displacement;
        }

    public String getDisplacement() {
        return displacement;
    }

}
