import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;


public class Game {
    private static final int MAX_ERROR = 7;
    private static Set<String> usedLetters;
    private static int countOfErrors = 0;
    private static StringBuilder displayWord;
    private static String currentWord;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        currentWord = Words.getWord();
        displayWord = new StringBuilder();
        displayWord.append("_".repeat(currentWord.length()));
        usedLetters = new HashSet<>();
        String input = null;
        countOfErrors = 0;
        while (true) {
            draw(countOfErrors);
            do {
                System.out.print("Введите букву: ");
                input = scanner.next().toLowerCase();
            } while (!validate(input));
            usedLetters.add(input);
            if (currentWord.contains(input)) {
                mapping(input);
                if (!displayWord.toString().contains("_")) {
                    System.out.println("Вы победили!");
                    System.out.println(currentWord.toUpperCase() + " - это слово было загадано\n");
                    break;
                }
            } else {
                countOfErrors += 1;
                if (countOfErrors == MAX_ERROR) {
                    System.out.println("Вы проиграли!");
                    System.out.println(currentWord.toUpperCase() + " - это слово было загадано\n");
                    break;
                }
            }
        }
    }

    private static boolean validate(String input) {
        if (input.length() > 1) {
            System.out.println("Нельзя вводить более одной буквы");
            return false;
        } else if (!Pattern.matches("[а-яА-Я]", input)) {
            System.out.println("Вы ввели не букву");
            return false;
        } else if (usedLetters.contains(input)) {
            System.out.println("Такая буква уже использовалась");
            return false;
        } else {
            return true;
        }
    }

    private static void mapping(String matchedLetter) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == matchedLetter.charAt(0)) {
                displayWord.setCharAt(i, matchedLetter.charAt(0));
            }
        }
    }

    private static void draw(int indexOfPhase) {
        System.out.println(Scaffold.getImage(indexOfPhase));
        System.out.println("\n" + displayWord + "\n");
        System.out.println("Количество ошибок: " + countOfErrors);
        System.out.println("Использованные символы: " + usedLetters);
    }
}
