package car.methodscars.set;
import car.Car;
import java.util.Objects;

public class greenToRed {
    public greenToRed(Car car) {
        String car_color = car.getColor();
        if (Objects.equals(car_color, "Green")) {
            car.setColor("Red");
            System.out.println("Авто перекрашено в красный цвет!");
        } else {
            System.out.println("У авто цвет не зелёный!");
        }
    }
}
