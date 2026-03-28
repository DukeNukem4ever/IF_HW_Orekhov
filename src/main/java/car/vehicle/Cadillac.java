package car.vehicle;
import car.Car;

public class Cadillac extends Car {
    public Cadillac(String name, String model, int price, int year, String transmission, String color, int avg_speed, String country) {
        super(name,
                "Cadillac",
                price,
                year,
                transmission,
                color,
                avg_speed,
                "USA");
    }
}
