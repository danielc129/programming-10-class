import java.util.*;

public class MathClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side A: ");
        double a = sc.nextDouble();
        System.out.print("Enter side B: ");
        double b = sc.nextDouble();
        System.out.println("The hypotenuse is " + findHypotenuse(a, b));
    }

    public static double findHypotenuse(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }
}
