import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        String password = "password";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password:");
        String input = sc.nextLine();
        if (password.equals(input)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Invalid password");
        }
    }
}
