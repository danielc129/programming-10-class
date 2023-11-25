public class ReturnValues {
    public static void main(String[] args) {
        System.out.println(lastDigit(-11123123));
        System.out.println(area(2));
        System.out.println(min(1, 5, -1));
        System.out.println(countQuarters(1278));
        System.out.println(pay(5.5, 6));
        System.out.println(pay(4, 11));
    }

    public static int lastDigit(int num) {
        return Math.abs(num % 10);
    }

    public static double area(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static int min(int a, int b, int c) {
        return Math.min(c, Math.min(a, b));
    }

    public static int countQuarters(int cents) {
        cents = cents % 100;
        return cents / 25;
    }

    public static double pay(double salary, double hours) {
        if (hours > 8) {
            return (salary * 8) + ((salary * 1.5) * (hours - 8));
        } else {
            return salary * hours;
        }
    }
}
