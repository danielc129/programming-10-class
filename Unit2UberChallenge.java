public class Unit2UberChallenge {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < (4 - i) * 6; j++) {
                System.out.print(" ");
            }
            System.out.print(" o ******");
            for (int j = 0; j < i * 6 ; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
            for (int j = 0; j < (4 - i) * 6; j++) {
                System.out.print(" ");
            }
            System.out.print("/|\\*");
            for (int j = 0; j < (i+1) * 6 - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();

            for (int j = 0; j < (4 - i) * 6; j++) {
                System.out.print(" ");
            }
            System.out.print("/ \\*");
            for (int j = 0; j < (i+1) * 6 - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();

        }
        for (int j = 0; j < 34; j++) {
            System.out.print("*");
        }
    }
}
