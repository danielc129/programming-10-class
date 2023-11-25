public class Unit2Review {

    public static void main(String[] args) {

        // question 5
        int sum = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.print(i * i + " ");
            sum += i * i;
        }
        System.out.println();
        System.out.println("Sum = " + sum + ".");

        // question 6
        System.out.print("-");
        for (int i = 0; i < 4; i++) {
            System.out.print("*-");
        }
        System.out.println();

        // question 7
        for (int i = 8; i >= 3; i--) {
            for (int j = 0; j < 3; j++) {
                System.out.print(i);
            }
            System.out.print(" ");
        }

        System.out.println();

        // question 8
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(j);
            }
        }
        System.out.println();

        //question 9
        for (int i = 0; i < 3; i++) {
            System.out.println("-*-*-*-*-");
        }

        // question 10
        for (int i = 3; i >= 1; i--) {

            for (int j = 0; j < (3 - i) * 3; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("-");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("-");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
