package car.methodscars.set;
import car.Car;
import java.util.Objects;

public class darkenColor {
    public darkenColor(Car car){
        String cur_color = car.getColor();
        if (cur_color.toLowerCase().contains("dark") ||
                Objects.equals(cur_color.toLowerCase(), "black") ||
                cur_color.toLowerCase().contains("white") ||
                cur_color.toLowerCase().contains("light")){
            System.out.println("Операция невозможна.");}
        else {
            car.setColor("Dark " + cur_color.toLowerCase());}
            System.out.println("Цвет машины " + car.getName() + ": " + car.getColor());
        }
    }
