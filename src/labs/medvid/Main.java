package labs.medvid;

import java.util.Scanner;

/**
 * Main entry point allowing user to choose between two tasks.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Оберіть роботу:");
        System.out.println("1 — Перша робота (табулювання функції)");
        System.out.println("2 — Друга робота (книги + вставка підрядка)");
        System.out.print("Ваш вибір: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                runFirstTask();
                break;

            case 2:
                runSecondTask();
                break;

            default:
                System.out.println("Невідомий вибір.");
        }
    }

    private static void runFirstTask() {
        System.out.println("=== Перша робота ===");
        FunctionTabulator tab = new FunctionTabulator();

        double start = 0.2;
        double end = 2.8;
        double step = 0.002;

        tab.generateArrays(start, end, step);

        int maxIndex = tab.indexOfMax();
        int minIndex = tab.indexOfMin();

        System.out.println("Максимум: x=" + tab.getX(maxIndex) + ", y=" + tab.getY(maxIndex));
        System.out.println("Мінімум: x=" + tab.getX(minIndex) + ", y=" + tab.getY(minIndex));
        System.out.println("Сума y: " + tab.sum());
        System.out.println("Середнє y: " + tab.average());
    }

    private static void runSecondTask() {
        System.out.println("=== Друга робота ===");

        // 1) Робота з рядками
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String text = s.nextLine();

        System.out.print("Введіть k: ");
        int k = s.nextInt();
        s.nextLine();

        System.out.print("Введіть підрядок: ");
        String sub = s.nextLine();

        System.out.println("Результат: " + StringInserter.insertAfter(text, k, sub));

        // 2) Масив книг
        Book[] books = {
                new Book(1, "1984", "Джордж Орвелл", "КМ-Букс", 2020, 300, 350, "М'яка"),
                new Book(2, "Місто", "Валер'ян Підмогильний", "Фоліо", 2019, 280, 200, "Тверда"),
                new Book(3, "Захар Беркут", "Іван Франко", "А-Ба-Ба-Га-Ла-Ма-Га", 2015, 220, 180, "Тверда"),
                new Book(4, "Кайдашева сім'я", "Нечуй-Левицький", "Ранок", 2018, 150, 150, "М'яка")
        };

        System.out.print("\nВведіть автора: ");
        String author = s.nextLine();
        BookManager.printByAuthor(books, author);

        System.out.print("\nВведіть видавництво: ");
        String publisher = s.nextLine();
        BookManager.printByPublisher(books, publisher);

        System.out.print("\nВведіть рік: ");
        int year = s.nextInt();
        BookManager.printAfterYear(books, year);
    }
}
