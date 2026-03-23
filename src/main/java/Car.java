import java.util.Objects;

public abstract class Car {
    String model;
    int year;
    String transmission;
    String color;
    int avg_speed;
    String country;

    // Конструктор
    public Car(String model,
        int year,
        String transmission,
        String color,
        int avg_speed,
        String country) {
        this.year = year;
        this.transmission = transmission;
        this.color = color;
        this.avg_speed = avg_speed;
        this.country = country;
    }

    public String getModel() { return model; }
    public int getYear() {
        return year;
    }
    public String getTransmission() {
        return transmission;
    }
    public String getColor() {
        return color;
    }
    public int getAvgSpeed() {
        return avg_speed;
    }
    public String getCountry() {
        return country;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Цвет машины изменён на " + color);
    }

    public void setAvgSpeed(int avg_speed) {
        this.avg_speed = avg_speed;
        System.out.println("Средняя скорость теперь составляет " + avg_speed);
    }

    public void checkDistance(int time) {
        int timed_speed = time * avg_speed;
        System.out.println("Сколько машина проедет за " + time + " часов: " + timed_speed);
    }

    // Нестатические функции

    void carStats() {
        if (year > 2006){
            System.out.println("Марка: " + this.model);
            System.out.println("Год: " + this.year);
            System.out.println("Передача: " + this.transmission);
            System.out.println("Цвет: " + this.color);
            System.out.println("Средняя скорость: " + this.avg_speed);
            System.out.println("Страна производства: " + this.country);
        }
        else {
            System.out.println("Устаревшее авто.");
        }
    }

    void greenToRed() {
        if (Objects.equals(this.color, "Green")) {
            this.color = "Red";
            System.out.println("Авто перекрашено в красный цвет!");
        } else {
            System.out.println("У авто цвет не зелёный!");
        }
    }

    void darkenColor() {
        if (!Objects.equals(this.color, "Black")) {
            this.color = "Dark " + this.color.toLowerCase();
            System.out.println("Цвет изменён!");
        }
        else {
            System.out.println("Темнее некуда!");
        }
    }
}

class CarEx extends Car {
    public CarEx(String model, int year, String transmission, String color, int avg_speed, String country) {
        super(model, year, transmission, color, avg_speed, country);
    }
}

class Toyota extends CarEx {
    public Toyota(String model, int year, String transmission, String color, int avg_speed, String country) {
        super(model,
                year,
                transmission,
                color,
                avg_speed,
                country);
        this.model = "Toyota";
        this.country = "Japan";
    }
}

class Suzuki extends CarEx {
    public Suzuki(String model, int year, String transmission, String color, int avg_speed, String country) {
        super(model,
                year,
                transmission,
                color,
                avg_speed,
                country);
        this.model = "Suzuki";
        this.country = "Japan";
    }
}

class Volga extends Car {
    public Volga(String model, int year, String transmission, String color, int avg_speed, String country) {
        super(model,
                year,
                transmission,
                color,
                avg_speed,
                country);
        this.model = "Volga";
        this.country = "Russia";
    }
}

class Ferrari extends Car {
    public Ferrari(String model, int year, String transmission, String color, int avg_speed, String country) {
        super(model,
                year,
                transmission,
                color,
                avg_speed,
                country);
        this.model = "Ferrari";
        this.country = "Italy";
    }
}

class Cadillac extends Car {
    public Cadillac(String model, int year, String transmission, String color, int avg_speed, String country) {
        super(model,
                year,
                transmission,
                color,
                avg_speed,
                country);
        this.model = "Cadillac";
        this.country = "USA";
    }
}