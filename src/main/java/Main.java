import car.Car;
import car.vehicle.Toyota;
import car.vehicle.Volga;
import car.vehicle.Ferrari;
import car.vehicle.Suzuki;
import car.vehicle.Cadillac;
import car.methodscars.set.carStats;
import car.methodscars.set.darkenColor;
import car.methodscars.set.greenToRed;
import car.methodscars.check.checkDistance;
import car.methodscars.check.checkDiscount;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //it's Main origin

    public static void main(String[] args) {

        // Составление списка для автомобилей:
        List<Car> cars = new ArrayList<>();
        cars.add(new Volga("Volga ZX-2", null, 243000, 2019, "Auto", "Red", 130, null));
        cars.add(new Volga("Volga Oldschool", null,75000, 1995, "Handy", "Black", 90, null));
        cars.add(new Toyota("Toyota Legacy",null, 143020,2002, "Handy", "Green", 100, null));
        cars.add(new Toyota("Toyota Slayer", null,405010, 2025, "Auto", "Yellow", 150, null));
        cars.add(new Suzuki("Suzuki Samurai", null, 750594,2022, "Auto", "White", 200, null));
        cars.add(new Suzuki("Suzuki Vintage", null,135043,1997, "Handy", "Cyan", 125, null));
        cars.add(new Ferrari("Ferrari Starline", null, 2845330,2026, "Auto", "Orange", 300, null));
        cars.add(new Ferrari("Ferrari Retro",null,120403,2000, "Handy", "Gray", 200, null));
        cars.add(new Cadillac("Cadillac Classic",null, 493059, 1986,"Handy", "Brown", 150, null));
        cars.add(new Cadillac("Cadillac Neo",null,1023045,2019, "Auto", "Blue", 300, null));

        Car car_1 = cars.getFirst();
        Car car_2 = cars.get(1);
        Car car_3 = cars.get(2);
        Car car_4 = cars.get(3);

        // Машина 1 - красим её в серебристый цвет.
        System.out.println("=========================");
        System.out.println(car_1.getName() + " (цвет - " + car_1.getColor() + ")");
        car_1.setColor("Silver");
        System.out.println(car_1.getName() + " (цвет - " + car_1.getColor() + ")");
        System.out.println("=========================");
        System.out.println(" ");

        // Машина 2 - делаем её цвет потемнее.
        System.out.println("=========================");
        System.out.println(car_2.getName() + " (цвет - " + car_2.getColor() + ")");
        new darkenColor(car_2);
        System.out.println("=========================");

        // Машина 3 - меняем её среднюю скорость
        System.out.println(" ");
        System.out.println("=========================");
        System.out.println(car_3.getName() + " (средняя скорость - " + car_3.getAvgSpeed() + ")");
        car_3.setAvgSpeed(150);
        System.out.println(car_3.getName() + " (средняя скорость - " + car_3.getAvgSpeed() + ")");
        System.out.println("=========================");

        // Машина 4 - изменим её название
        System.out.println(" ");
        System.out.println("=========================");
        System.out.println("Имя машины: " + car_4.getName());
        car_4.changeName("Toyota Super");
        System.out.println("Имя машины: " + car_4.getName());
        System.out.println("=========================");

        // Массовая перекраска зелёных автомобилей в красный цвет
        System.out.println(" ");
        System.out.println("=========================");
        for (Car car: cars) {
            System.out.println(car.getName() + " (цвет - " + car.getColor() + ")");
            new greenToRed(car);
            System.out.println(" ");
            }
        System.out.println("=========================");

        // Расстояние, которое все машины проедут за 5 часов:
        System.out.println(" ");
        System.out.println("=========================");
        for (Car car: cars) {
            new checkDistance(car, 5);
            System.out.println(" ");
        }
        System.out.println("=========================");

        // Статистика по машинам после 2006 года:
        System.out.println(" ");
        System.out.println("=========================");
        new carStats(cars);
        System.out.println("=========================");

        // Проверка цен машин по скидке 25%:
        System.out.println(" ");
        System.out.println("=========================");
        for (Car car : cars){
            new checkDiscount(car, 25);
            System.out.println(" ");
        }
        System.out.println("=========================");

        // Затемнение цвета машин:
        System.out.println(" ");
        System.out.println("=========================");
        for (Car car : cars){
            System.out.println("Цвет машины " + car.getName() + ": " + car.getColor());
            new darkenColor(car);
            System.out.println(" ");
        }
        System.out.println("=========================");
}
    }


