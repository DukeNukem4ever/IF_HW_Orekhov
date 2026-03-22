import java.util.ArrayList;
import java.util.List;

public class Main {
    //it's Main origin
    public static void main(String[] args) {
        Toyota toyota = new Toyota("Toyota",2007,"Handy","Green",123, "Japan");

        // Проверка дистанции Тойоты за 6 часов.
        toyota.checkDistance(6);

        // Смена цвета Тойоты.
        toyota.getColor();
        toyota.setColor("Blue");
        toyota.getColor();

        // Проверка общего расстояния, которое проедет Toyota
        toyota.checkDistance(5);

        // Составление списка для автомобилей:
        List<Car> cars = new ArrayList<>();
        Car volkswagen = new CarEx(
                "Volkswagen",
                2005,
                "Handy",
                "Yellow",
                100,
                "Germany");
        Car renault = new CarEx(
                "Renault",
                2008,
                "Auto",
                "Black",
                125,
                "France");
        Car porsche = new CarEx(
                "Porsche",
                2016,
                "Auto",
                "Silver",
                115,
                "Germany");
        Car holden = new CarEx(
                "Holden",
                2004,
                "Handy",
                "Blue",
                130,
                "Australia");
        Car hyundai = new CarEx(
                "Hyundai",
                2024,
                "Auto",
                "Purple",
                120,
                "South Korea");
        Car chevrolet = new CarEx(
                "Chevrolet",
                2017,
                "Auto",
                "Pink",
                109,
                "USA"
        );
        Car dodge = new CarEx(
                "Dodge",
                2014,
                "Auto",
                "Red",
                125,
                "USA"
        );
        Car ford = new CarEx(
                "Ford",
                2010,
                "Handy",
                "White",
                95,
                "USA"
        );
        Car nissan = new CarEx(
                "Nissan",
                2021,
                "Auto",
                "Green",
                100,
                "Japan"
        );
        Car mercedes = new CarEx(
                "Mercedes",
                2019,
                "Auto",
                "Orange",
                98,
                "Germany"
        );

        cars.add(volkswagen);
        cars.add(renault);
        cars.add(porsche);
        cars.add(holden);
        cars.add(hyundai);
        cars.add(chevrolet);
        cars.add(dodge);
        cars.add(ford);
        cars.add(nissan);
        cars.add(mercedes);

        // Тестирование статических методов
        System.out.println("Цвет Мерседеса: " + mercedes.getColor());
        mercedes.darkenColor();
        System.out.println("Цвет Мерседеса: " + mercedes.getColor());
        mercedes.greenToRed();
        System.out.println("Статистика Порше: " + mercedes.getColor());
        mercedes.darkenColor();
    }
}


