import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a month:");
        String month = sc.nextLine();
        month = month.toLowerCase();
        if (month.equals("january")) {
            System.out.println("31 days");
        } else if (month.equals("february")) {
            System.out.println("28 days");
        } else if (month.equals("march")){
            System.out.println("31 days");
        } else if (month.equals("april")) {
            System.out.println("30 days");
        } else if (month.equals("may")) {
            System.out.println("31 days");
        } else if (month.equals("june")) {
            System.out.println("30 days");
        } else if (month.equals("july")) {
            System.out.println("31 days");
        } else if (month.equals("august")) {
            System.out.println("31 days");
        } else if (month.equals("september")) {
            System.out.println("30 days");
        } else if (month.equals("october")) {
            System.out.println("31 days");
        } else if (month.equals("november")) {
            System.out.println("30 days");
        } else if (month.equals("december")) {
            System.out.println("31 days");
        } else {
            System.out.println("please check your input and try again");
        }
    }
}
