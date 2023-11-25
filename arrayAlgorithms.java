import java.util.Arrays;

public class arrayAlgorithms {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        shift(a);
        System.out.println(Arrays.toString(a));
        shift(a);
        System.out.println(Arrays.toString(a));
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length-1]);
        System.out.println("]");
    }

    public static boolean equals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] reverse(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[arr.length - 1 - i] = arr[i];
        }

        return temp;
    }

    public static boolean search(int[] arr, int val) {
        for (int i : arr) {
            if (val == i) {
                return true;
            }
        }
        return false;
    }

    public static void shift(int[] arr) {
        int[] sec = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            sec[i] = arr[i];
        }
        System.out.println(Arrays.toString(sec));
        arr[0] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sec[i-1];
        }
    }


}
