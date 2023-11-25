import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("First name:");
        String firstName = sc.nextLine();
        System.out.println("Last name:");
        String lastName = sc.nextLine();
        System.out.println("Gender (M/F):");
        String gender = sc.nextLine();
        System.out.println("Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Are you married (Y/N):");
        String married = sc.nextLine();
        System.out.println("Are you a doctor (Y/N):");
        String doctor = sc.nextLine();
        System.out.println("Do you have a PhD (Y/N):");
        String phd = sc.nextLine();

        System.out.print("Good morning, ");
        if (phd.equals("Y") || doctor.equals("Y")) {
            System.out.print("Dr. ");
        } else if (gender.equals("F") && married.equals("N")) {
            System.out.print("Ms. ");
        } else if (gender.equals("F") && married.equals("Y")) {
            System.out.print("Mrs. ");
        } else if (gender.equals("M") && age < 18) {
            System.out.print("Master ");
        } else if (gender.equals("M") && age >= 18) {
            System.out.print("Mr. ");
        }

        System.out.print(firstName + " " + lastName + "\n");
    }
}
