import org.w3c.dom.ls.LSOutput;

public class starFigures { public static void main(String[] args) {
        patternA();
        patternB();
        System.out.println();
        patternA();
        patternB();
        patternA();
        System.out.println();
        patternC();
        patternA();
        patternB();
    }

    public static void patternA() {
        System.out.println("*****");
        System.out.println("*****");
    }

    public static void patternB() {
        System.out.println(" * * ");
        System.out.println("  *  ");
        System.out.println(" * *");
    }

    public static void patternC() {
        System.out.println("  *  ");
        System.out.println("  *  ");
        System.out.println("  *  ");
    }
}
