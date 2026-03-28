package car.vehicle;

import car.Car;

public class Toyota extends Car {
    public Toyota(String name, String model, int price, int year, String transmission, String color, int avg_speed, String country) {
        super(name,
                "Toyota",
                price,
                year,
                transmission,
                color,
                avg_speed,
                "Japan");
    }
}


