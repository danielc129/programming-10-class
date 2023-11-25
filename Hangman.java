/*
Console Hangman Game
Daniel Chen
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    private static final int SIZE = 9894; // Number of words in word list

    // Prints the hangman figure
    public static void printHangman(int lives) {

        lives = 8 - lives; // It's actually the other way around

        if (lives == 7) {
            String s = """
                      +---+
                      |   |
                      O   |
                     /|\\  |
                     / \\  |
                          |
                    =========
                    """;
            System.out.println(s);
        } else if (lives == 6) {
            String s = """
                      +---+
                      |   |
                      O   |
                     /|\\  |
                     /    |
                          |
                    =========
                    """;
            System.out.println(s);
        } else if (lives == 5) {
            String s = """
                      +---+
                      |   |
                      O   |
                     /|\\  |
                          |
                          |
                    =========
                    """;
            System.out.println(s);
        } else if (lives == 4) {
            String s = """
                      +---+
                      |   |
                      O   |
                     /|   |
                          |
                          |
                    =========
                    """;
            System.out.println(s);
        } else if (lives == 3) {
            String s = """
                      +---+
                      |   |
                      O   |
                      |   |
                          |
                          |
                    =========
                    """;
            System.out.println(s);
        } else if (lives == 2) {
            String s = """
                      +---+
                      |   |
                      O   |
                          |
                          |
                          |
                    =========
                    """;
            System.out.println(s);
        } else if (lives == 1) {
            String s = """
                      +---+
                      |   |
                          |
                          |
                          |
                          |
                    =========
                    """;
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] wordsList = new String[SIZE]; // holds list of words
        URL website = new URL("https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt"); // txt file containing words
        File tempFile = File.createTempFile("Hangman-", ".tmp"); // tempfile to download words into
        tempFile.deleteOnExit();
        try { // Download txt file into tempFile
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch(IOException e) {
            System.out.println("Failed to download words list");
            System.out.println("Please run the program again");
        }

        File wordsTxt = tempFile;
        Scanner reader = new Scanner(wordsTxt); // words file scanner
        Scanner sc = new Scanner(System.in); // console input scanner
        for (int i = 0; i < SIZE; i++) {
            wordsList[i] = reader.nextLine(); // Read each line, which contains one word, into the wordsList array
        }

        System.out.println("Welcome to Hangman!");
        System.out.println("Please size your terminal to accommodate 15 or more lines");


        String cont = "y";
        while (cont.equals("y")) { // Game loop, runs while user wants to cont.
            int appender = 0; // used to append to wrongGuesses array

            System.out.println("Press ENTER to begin");
            sc.nextLine();

            String word = wordsList[(int) (Math.random() * SIZE)];
            word = word.toUpperCase(); // Select random word

            // Game data setup
            char[] wordArr = word.toCharArray();
            char[] wrongGuessed = new char[26];
            char[] guess = new char[word.length()];
            Arrays.fill(guess, '_'); // guess by default is filled with _ and it prints like that too, when the player guesses the _ is changed to the right letter
            int lives = 7;

            while (!Arrays.equals(wordArr, guess)) {
                if (lives == 0) {
                    System.out.println("You ran out of lives!");
                    System.out.println("The correct word was: " + word);
                    break;
                }

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // new frame
                printHangman(lives);

                if (wrongGuessed[0] != 0) { // Checks if wrongGuessed has its first element changed, meaning that there is at least one wrong guess
                    // list wrong guesses
                    System.out.print("Wrong guesses: ");
                    for (char c : wrongGuessed) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                }

                System.out.println();

                for (char c : guess) { // print the letters in the guess array
                    System.out.print(c + " ");
                }

                System.out.println();
                System.out.println();
                System.out.println("Enter a letter: ");
                String g = sc.nextLine();
                while (g.length() != 1) { // check length = 1
                    System.out.println("Enter a letter: ");
                    g = sc.nextLine();
                }
                g = g.toUpperCase();
                char gg = g.charAt(0);
                while(gg < 65 || gg > 90) { // check input is a letter
                    System.out.println("Enter a letter:");
                    g = sc.nextLine();
                    g = g.toUpperCase();
                    gg = g.charAt(0);
                }
                boolean changed = false; // Was the guess right?
                boolean skip = false; // Skip this loop if they guessed this letter already

                for (char c : wrongGuessed) { // check wrongGuessed for skip
                    if (c == gg) {
                        skip = true;
                    }
                }

                for (char c : guess) { // check guess for skip
                    if (c == gg) {
                        skip = true;
                    }
                }

                if (skip) {
                    continue;
                }

                for (int i = 0; i < word.length(); i++) { // go through guess array and set the guessed letter to actually be that
                    if (wordArr[i] == gg) {
                        guess[i] = gg;
                        changed = true;
                    }
                }

                if (!changed) { // !changed means guess was wrong, so decrease a life and add it to the wrongGuessed array
                    lives--;
                    wrongGuessed[appender] = gg;
                    appender++;
                }

                if (Arrays.equals(guess, wordArr)) {
                    System.out.println("You got it!");
                    System.out.println("The word is: " + word);
                }
            }


            System.out.println();
            System.out.println("Do you want to play again? (y/n): ");
            cont = sc.nextLine();

            while (!cont.equals("y") && !cont.equals("n")) {
                System.out.println("Do you want to play again? (y/n): ");
                cont = sc.nextLine();
            }

        }
    }
}
