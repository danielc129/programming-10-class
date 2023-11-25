import java.util.Scanner;

public class anotherMethodProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        System.out.println(square(n));
    }

    public static int square(int n) {
        System.out.println("output");
        return n*n;
    }
}
