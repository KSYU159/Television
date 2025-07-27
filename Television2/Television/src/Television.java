import java.util.Random;
import java.util.Scanner;

// Класс Телевизор (приватный):
class Television {
    private final String brand;
    private final double diagonal;
    private boolean isOn;

    // Конструктор
    public Television(String brand, double diagonal) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.isOn = false;
    }

    // Методы управления питанием (Вкл/Выкл)
    public void powerOn() { isOn = true; }

    // Переопределение toString()
    @Override
    public String toString() {
        return "Телевизор " + brand +
                " (диагональ: " + diagonal + "\")" +
                " - " + (isOn ? "Включен" : "Выключен");
    }
}

// Класс App (публичный):
class App {
    public static void main(String[] args) {
        // Создание телевизоров со случайными параметрами
        Television tv1 = createRandomTV();
        Television tv2 = createRandomTV();

        // Создание телевизора с параметрами от пользователя
        Television tv3 = createUserTV();

        // Демонстрация работы
        tv1.powerOn();
        tv3.powerOn();

        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
    }

    // Создание телевизора со случайными параметрами
    private static Television createRandomTV() {
        Random rand = new Random();
        String[] brands = {"Samsung", "LG", "Sony", "Philips", "Xiaomi", "Haier", "Электроника", "Горизонт", "Рубин"};
        return new Television(
                brands[rand.nextInt(brands.length)],
                20 + rand.nextDouble() * 60
        );
    }

    // Создание телевизора с вводом параметров от пользователя
    private static Television createUserTV() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите бренд телевизора: ");
        String brand = scanner.nextLine();
        System.out.print("Введите диагональ (дюймы): ");
        double diagonal = scanner.nextDouble();
        return new Television(brand, diagonal);
    }
}