import java.util.ArrayList;

public class Arraylistss {
    public static void main(String[] args) {
        ArrayList<String> bruh = new ArrayList<String>();
        bruh.add("a");
        bruh.add("ab");
        bruh.add("aoaneutaotnehsushatoneu");
        bruh.add("a");
        System.out.println(maxLength(bruh));
        System.out.println(bruh);
    }

    public static int maxLength(ArrayList<String> arr) {
        int max = 0;
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }
}
