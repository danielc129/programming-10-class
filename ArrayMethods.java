import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
        System.out.println(average(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));

        int[] numbers = new int[8];
        int[] newNumbers = new int[numbers.length * 2];
        newNumbers = Arrays.copyOf(numbers, 3);
        Arrays.fill(numbers, 42);

        int[] test = {27,15,11,15,27};
        System.out.println(mode(test));


    }

    public static int max(int[] arr) {
        int maximum = -1;
        for(int num : arr) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }

    public static double average(int[] arr) {
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum / arr.length;
    }

    public static int range(int[] arr) {
        int min = 999999999;
        int max = -1;

        if (arr.length == 1) {
            return arr[0];
        }
        for (int c : arr) {
            if (c < min) {
                min = c;
            }

            if (c > max) {
                max = c;
            }
        }

        return max - min;
    }

    public static int mode(int arr[]) {
        int selected = -1;
        int prevFreq = -1;
        Arrays.sort(arr);

        for (int num : arr) {
            int counter = 0;
            for (int c : arr) {
                if (c == num) {
                    counter++;
                }
            }
            if (counter > prevFreq) {
                prevFreq = counter;
                selected = num;
            }
        }

        return selected;

    }
}
