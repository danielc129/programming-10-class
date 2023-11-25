import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weight:");
        double weight = sc.nextDouble();
        System.out.println("Enter height");
        double height = sc.nextDouble();
        System.out.println("BMI is " + (weight / Math.pow(height / 100, 2)));
    }
}
