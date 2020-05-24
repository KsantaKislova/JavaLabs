import by.gsu.pms.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("src/in.txt"));
            StringBuilder sb = new StringBuilder("");
            while (in.hasNext())
                sb.append(in.nextLine());
            Text text = new Text(sb.toString());
            System.out.println(text.getText());
            text.removeExcessSpaces();
            System.out.println(text.getText());
            List<Word> vowelWords = Word.getWordsStartWithVowel(text.getWords());
            Collections.sort(vowelWords);
            for (Word w :
                    vowelWords) {
                System.out.println(w.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
