package car.methodscars.set;
import car.Car;
import java.util.List;

public class carStats {
    public carStats(List<Car> cars) {
        for (Car car: cars) {
             System.out.println(car.getName());
            if (car.getYear() > 2006){
                car.carInfo();
            }
            else {
                System.out.println("Устаревшее авто.");
            }
            System.out.println(" ");
        }
    }
}
