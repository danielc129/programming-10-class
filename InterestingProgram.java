public class InterestingProgram {

    public static void main(String[] args) {
        // infinite loop that runs myMethod
        while (true ){
            myMethod();
        }
    }

    public static void myMethod() {
        // prints numbers from 1 to 100
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println("let's do it again!");
    }
}
