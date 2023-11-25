public class Project2 {

    public static void main(String[] args) {
        end(); // starting line

        // shrinking towards middle
        for (int i = 0; i < 4; i++) {

            // whitespace before characters
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }

            // starting slash
            System.out.print("\\");

            // colons
            for (int j = 0; j < 7 - (i * 2); j++) {
                System.out.print(":");
            }

            // ending slash
            System.out.println("/");
        }

        // expanding out of middle
        for (int i = 0; i < 4; i++) {

            // whitespace before characters
            for (int j = 0; j < 5 - (i + 1); j++) {
                System.out.print(" ");
            }

            // starting slash
            System.out.print("/");

            // colons
            for (int j = 0; j < (i * 2) + 1; j++) {
                System.out.print(":");
            }

            // ending slash
            System.out.println("\\");
        }

        end(); // ending line

    }

    // prints starting/ending line
    public static void end() {
        System.out.println("|\"\"\"\"\"\"\"\"\"|");
    }
}
