import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        printIndex(a);
    }

    public static void printIndex(String s) {
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            System.out.print(s.length() - i - 1);
        }
    }

    public static double scientific(double base, int exponent) {
        return base * Math.pow(10, exponent);
    }
}
