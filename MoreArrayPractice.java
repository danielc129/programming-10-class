import java.util.Arrays;

public class MoreArrayPractice {
    public static void main(String[] args) {
        System.out.println(isPalindrome(new String[]{"alpha", "beta", "gamma", "delta", "gamma", "beta", "alpha"}));
    }

    public static void printBackwards(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("element [" + i + "] is " + arr[i]);
        }
    }

    public static boolean isPalindrome(String[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return true;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            String first = arr[i];
            String second = arr[arr.length - i - 1];
            if (!first.equals(second)) {
                return false;
            }
        }

        return true;
    }
}
