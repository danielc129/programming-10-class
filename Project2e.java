import static java.lang.Math.abs;

public class Project2e {
    public static void main(String[] args) {
        end(); // starting line

        // middle section
        for (int i = -3; i < 5; i++) {

            // whitespace before characters
            for (int j = 0; j < 4 - (i <= 0 ? abs(i) : abs(i) - 1) ; j++) {
                System.out.print(" ");
            }

            // starting slash
            System.out.print(i > 0 ? "/" : "\\");

            // colons
            for (int j = 0; j < (i <= 0 ? (abs(i) * 2 + 1) : (abs(i) * 2 - 1)); j++) {
                System.out.print(":");
            }

            // ending slash
            System.out.println(i > 0 ? "\\" : "/");
        }

        end(); // ending line

    }

    // prints starting/ending line
    public static void end() {
        System.out.println("|\"\"\"\"\"\"\"\"\"|");
    }
}
