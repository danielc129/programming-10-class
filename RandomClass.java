import java.util.Random;
import java.util.Scanner;

public class RandomClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Guess a random number between 1 and 10:");
        int guess = sc.nextInt();
        int number = rand.nextInt(10) + 1;
        int counter = 1;

        if (guess == number) {
            System.out.println("Holy Toledo! You got it right on the first try?!");
        } else {
            while (guess != number) {
                System.out.println("Incorrect. Attempt #" + counter);
                if (guess > number) {
                    System.out.println("Guess was too high.");
                } else {
                    System.out.println("Guess was too low.");
                }

                System.out.println("Guess a random number between 1 and 10:");
                guess = sc.nextInt();
                counter++;
            }
        }

        System.out.println("Correct");
    }


}
