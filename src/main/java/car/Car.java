package car;

public abstract class Car {
    String name;
    String model;
    int price;
    int year;
    String transmission;
    String color;
    int avg_speed;
    String country;

    // Конструктор
    public Car(String name,
               String model,
        int price,
        int year,
        String transmission,
        String color,
        int avg_speed,
        String country) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.year = year;
        this.transmission = transmission;
        this.color = color;
        this.avg_speed = avg_speed;
        this.country = country;
    }

    // Информация о машине
    public String getName() { return name; }
    public String getModel() { return model; }
    public int getPrice() { return price; }
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
    public String toString() {return name + " (" + model + "; " + color + "; " + year + ") - " + price + " $";}

    public void carInfo() {
        System.out.println("Название: " + model);
        System.out.println("Марка: " + model);
        System.out.println("Передача: " + transmission);
        System.out.println("Цвет: " + color);
        System.out.println("Средняя скорость: " + avg_speed);
        System.out.println("Цена (в долларах): " + price);
        System.out.println("Страна производства: " + country);
        System.out.println("Год: " + year);
    }

    public void setColor(String new_color) {
        this.color = new_color;
        System.out.println("Цвет машины изменён на " + new_color);
    }

    public void changeName(String new_name) {
        this.name = new_name;
        System.out.println("Машина переименована. Новое имя: " + new_name);
    }

    public void setAvgSpeed(int avg_speed) {
        this.avg_speed = avg_speed;
        System.out.println("Средняя скорость теперь составляет " + avg_speed);
    }

    //public void checkDistance(int time) {
    //    int timed_speed = time * this.getAvgSpeed();
    //    System.out.println("Сколько машина проедет за " + time + " часов: " + timed_speed);
    //    }
}
    //public void checkDistance(int time) {
    //        int timed_speed = time * this.avg_speed;
    //        System.out.println("Сколько машина проедет за " + time + " часов: " + timed_speed);
    //}

    //void darkenColor() {
    //    if (!Objects.equals(this.color, "Black")) {
    //        this.color = "Dark " + this.color.toLowerCase();
    //        System.out.println("Цвет изменён!");
    //    }
    //    else {
    //        System.out.println("Темнее некуда!");
    //    }
    //}
