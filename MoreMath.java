public class MoreMath {
    public static void main(String[] args) {
        System.out.println(cylinderSurfaceArea(3.0, 4.5));
    }

    public static double cylinderSurfaceArea(double radius, double height) {
        return (2 * Math.PI * Math.pow(radius, 2)) + (2 * Math.PI * radius * height);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int largerAbsVal(int a, int b) {
        return Math.max(Math.abs(a), Math.abs(b));
    }

    public static int largestAbsVal(int a, int b, int c) {
        return Math.max(Math.abs(c), Math.max(Math.abs(a), Math.abs(b)));
    }
}
