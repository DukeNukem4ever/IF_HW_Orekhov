package car.vehicle;

import car.Car;

public class Suzuki extends Car {
    public Suzuki(String name, String model, int price, int year, String transmission, String color, int avg_speed, String country) {
        super(name,
                "Suzuki",
                price,
                year,
                transmission,
                color,
                avg_speed,
                "Japan");
    }
}
