public class NestedForLoops {
    public static void main(String[] args) {
        for(int i = 0; i < 2; i++) {
            for (int j = 1; j <= 21; j+=2) {
                if (i == 1 && j >= 12) {
                    break;
                }
                System.out.print(j + " ");

            }
            System.out.println();
        }

        System.out.println("\n\n\n");
        for (int i = 0; i < 6; i++) {
            int stars = 6 - i;
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n\n\n");

        for (int i = 0; i < 5; i++) {
            int stars = (i*2) + 1;
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("- ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print(stars + " ");
            }

            for (int j = 0; j < 5 - i; j++) {
                System.out.print("- ");
            }
            System.out.println();
        }

        System.out.println("\n\n\n");


    }
}
