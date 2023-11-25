public class ParametersContinued {
    public static void main(String[] args) {
        drawBox(3);
    }

    public static void printStrings(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(str);
        }
    }

    public static void pattern(String str, int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < b; k++) {
                    System.out.print("#");
                }
                System.out.println(str);
            }
            System.out.println();
        }
    }

    public static void drawBox(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int j = 0; j < size / 3; j++) {
            System.out.print("|");
            for (int i = 0; i < (size - 1) * 2 - 1; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();}
        for (int i = 0; i < size; i++) {
            System.out.print("- ");
        }
    }
}
