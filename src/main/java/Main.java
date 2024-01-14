import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Нажми [И]грать или [В]ыход:");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("и")) {
                Game.start();
            } else if (choice.equals("в")) {
                break;
            } else {
                System.out.println("Неверный ввод");
            }
        }
        scanner.close();
    }
}
