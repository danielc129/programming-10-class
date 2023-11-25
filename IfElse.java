import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Minimum: " + Math.min(a, b));
        System.out.println("Maximum: " + Math.max(a, b));
    }
}
