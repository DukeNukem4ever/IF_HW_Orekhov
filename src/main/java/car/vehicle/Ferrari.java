package car.vehicle;

import car.Car;

public class Ferrari extends Car {
    public Ferrari(String name, String model, int price, int year, String transmission, String color, int avg_speed, String country) {
        super(name,
                "Ferrari",
                price,
                year,
                transmission,
                color,
                avg_speed,
                "Italy");
    }
}