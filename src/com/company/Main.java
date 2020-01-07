package com.company;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Armo una ArrayList para almacenar ambas subclases
        List<Vehicle> vehicles = new ArrayList<>();

        //asigno e inicializo variables para mostrar el vehículo más caro, el más barato y el que contiene la letra 'Y'
        double mostExpensivePrice = 0;
        String mostExpensiveName = "";
        double leastExpensivePrice = 999999999;
        String leastExpensiveName = "";
        String containsY = "";

        // creo los objetos pedidos en el ejercicio mediante esta funcion
        vehicles = generateVehicleData();

        //loop encargado de conseguir todas las respuestas necesarias mediante funciones estaticas
        for (int i = 0; i < vehicles.size(); i++) {
            //chequear si el objeto es auto o moto para mostrar la informacion correcta
            if (vehicles.get(i) instanceof Car) {
                Car tempCar = (Car) vehicles.get(i);
                 showInfo(tempCar);
            } else {
                Motorcycle tempMoto = (Motorcycle) vehicles.get(i);
                showInfo(tempMoto);
            }
            //chequear si el vehiculo es el mas caro, mas barato o si contiene la letra 'Y' en el modelo
            if (vehicles.get(i).getPrice() > mostExpensivePrice) {
                mostExpensivePrice = vehicles.get(i).getPrice();
                mostExpensiveName = vehicles.get(i).getBrand() + " " + vehicles.get(i).getModel();
            }
            if (vehicles.get(i).getPrice() < leastExpensivePrice) {
                leastExpensivePrice = vehicles.get(i).getPrice();
                leastExpensiveName = vehicles.get(i).getBrand() + " " + vehicles.get(i).getModel();
            }
            if (checkIfY(vehicles.get(i).getModel())) {
                containsY = vehicles.get(i).getBrand() + " " + vehicles.get(i).getModel() + " " + giveDecimalFormat(vehicles.get(i).getPrice());
            }
        }

        //salida a la consola
        System.out.println("===================================");
        System.out.println("Vehículo más caro: " + mostExpensiveName +
                "\nVehículo más barato: " + leastExpensiveName +
                "\nVehículo que contiene en el modelo la letra 'Y' : " + containsY);
        System.out.println("===================================");
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        //ejercicio extra, ordena la lista de vehiculos mediante una funcion e imprime los modelos en orden descendente
        List<String> sortedVehicles = sortedVehicles(vehicles);
        for( String i : sortedVehicles){
            System.out.println(i);
        }


    }
    //metodo encargado de generar los objetos y agregarlos a la lista
    public static List<Vehicle> generateVehicleData(){
        // creo los objetos pedidos en el ejercicio
        List<Vehicle> vehicles = new ArrayList<>();

        Car auto1 = new Car("Peugeot", "206", 200000.00, 4);
        vehicles.add(auto1);
        Motorcycle moto1 = new Motorcycle("Honda", "Titan", 60000.00, "125c");
        vehicles.add(moto1);
        Car auto2 = new Car("Peugeot", "208", 250000.00, 5);
        vehicles.add(auto2);
        Motorcycle moto2 = new Motorcycle("Yamaha", "YBR", 80500.50, "160c");
        vehicles.add(moto2);

        return vehicles;
    }

    //metodos encargados de mostrar la informacion acorde a cada subclase
    public static void showInfo(Car auto) {
        System.out.println("Marca: " + auto.getBrand() + " // " + "Modelo: " + auto.getModel() + " // " + "Puertas: " + auto.getDoors() + " // " + "Precio: " + giveDecimalFormat(auto.getPrice()));
    }

    public static void showInfo(Motorcycle moto) {
        System.out.println("Marca: " + moto.getBrand() + " // " + "Modelo: " + moto.getModel() + " // " + "Puertas: " + moto.getDisplacement() + " // " + "Precio: " + giveDecimalFormat(moto.getPrice()));
    }
    //metodo encargado de verificar que el modelo del objeto de clase contenga el caractér 'Y'
    public static boolean checkIfY(String model) {
        return model.toLowerCase().indexOf('y') > -1;
    }
    //metodo encargado de dar el formato acorde al precio de cada vehiculo
    public static String giveDecimalFormat(double price) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return "$" + df.format(price);
    }
    //metodo encargado de ordenar los vehiculos en un nueva lista de forma descendiente
    public static List<String> sortedVehicles(List<Vehicle> vehicles) {
        List<String> sortedVehicles = new ArrayList<>();
        while(vehicles.size()>0) {
            int i = 0;
            int minIndex = i;
                for (int j = i + 1; j < vehicles.size(); j++) {
                    if (vehicles.get(j).getPrice() > vehicles.get(minIndex).getPrice()) {
                        minIndex = j;
                    }
                }
                String minvalue = vehicles.get(minIndex).getBrand() + " " + vehicles.get(minIndex).getModel();
                sortedVehicles.add(minvalue);
                vehicles.remove(minIndex);
        }
       return sortedVehicles;
    }
}