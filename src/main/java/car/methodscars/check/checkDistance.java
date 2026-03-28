package car.methodscars.check;
import car.Car;

public class checkDistance {
    public checkDistance(Car car, int time) {
        int timed_speed = time * car.getAvgSpeed();
        System.out.println("Сколько машина " + car.getName() + " проедет за " + time + " часов: " + timed_speed);
        }
}
