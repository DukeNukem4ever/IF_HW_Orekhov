package car.methodscars.check;
import car.Car;

public class checkDiscount {
    public checkDiscount(Car car, int discount) {
        double new_price = car.getPrice() - (double) discount / 100 * car.getPrice();
        System.out.println("Цена автомобиля "
                + car.getName() +
                " по скидке " + discount + "%: "
                + Math.round(new_price) + " $.");
    }
}
