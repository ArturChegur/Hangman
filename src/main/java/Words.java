import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;


public class Words {
    private static final Random rand = new Random();
    private static final List<String> VOCABULARY = new ArrayList<>();

    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("words.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            VOCABULARY.add(scanner.nextLine());
        }
        scanner.close();
    }

    public static String getWord() {
        int index = rand.nextInt(VOCABULARY.size());
        return VOCABULARY.get(index);
    }
}
