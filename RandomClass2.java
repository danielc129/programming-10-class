import java.util.Random;

public class RandomClass2 {
    public static void main(String[] args) {
        randomX();
    }

    public static void makeGuesses(int num) {
        Random r = new Random();
        int counter = 1;
        int guess = r.nextInt(0, 50) + 1;

        while (guess != num) {
            System.out.println("Guess = " + guess + "... nope!");
            guess = r.nextInt(0, 50) + 1;
            counter++;
        }

        System.out.println("Guess = " + guess + "... yes!");

        System.out.println("Total Guesses = " + counter);
    }

    public static void randomX() {
        Random r = new Random();
        int x = r.nextInt(0, 16) + 5;
        while (x != 16) {
            for (int i = 0; i < x; i++) {
                System.out.print("x");
            }
            System.out.println();
            x = r.nextInt(0, 16) + 5;
        }

        for (int i = 0; i < 16; i++) {
            System.out.print("x");
        }


    }
}
