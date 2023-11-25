 import java.util.*;

 import static java.lang.Math.PI;
 import static java.lang.Math.sqrt;

 public class FirstProgram {

    public static void change(int num) {
        num = 5;
    }



    public static void main(String[] args) {


    }

    public static int indexOf(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid;
            }
        }

        return -1;
    }

}
