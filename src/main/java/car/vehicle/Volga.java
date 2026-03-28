package car.vehicle;

import car.Car;

public class Volga extends Car {

    public Volga(String name, String model, int price, int year, String transmission, String color, int avg_speed, String country) {
        super(name,
                model,
                price,
                year,
                transmission,
                color,
                avg_speed,
                "Russia");
    }
}
