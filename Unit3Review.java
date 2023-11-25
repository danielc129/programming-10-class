import java.util.Random;
import java.util.Scanner;

public class Unit3Review {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String thing = sc.nextLine();
        System.out.println(scrambleWord(thing));
    }



    public static void randomMethod(int num) {
        System.out.println(num * 3);
    }

    public static String scrambleWord(String word) {
        String newWord = "";

        if (word.length() < 1) {
            return word;
        }
        for (int i = 0; i < word.length() - 1; i++) {


            if (word.charAt(i) == 'A' && !(word.charAt(i + 1) == 'A')) {
                newWord += word.charAt(i+1);
                newWord += word.charAt(i);
                i++;
            } else {
                newWord += word.charAt(i);
                if (i == word.length() - 2) {
                    newWord += word.charAt(word.length() - 1);
                }
            }
        }
        return newWord;
    }
}
