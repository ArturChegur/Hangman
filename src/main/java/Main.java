import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press [P]lay or [E]xit:");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("p")) {
                Game.start();
            } else if (choice.equals("e")) {
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
        scanner.close();
    }
}
