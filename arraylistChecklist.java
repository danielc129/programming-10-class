/*
Project for arrays, multi-dimensional arrays, and arraylists
Group: Daniel, Christine, and Eric
 */

import java.util.ArrayList;

public class arraylistChecklist {

    public static void scaledByK(ArrayList<Integer> arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer c : arr) {
            for (int i = 0; i < c; i++) {
                temp.add(c); // add the value c, c number of times, to temp
            }
        }

        // now temp is the desired array
        // write each value into the original array
        for (int i = 0; i < temp.size(); i++) {
            if (i < arr.size()) {
                arr.set(i, temp.get(i));
            } else {
                arr.add(temp.get(i));
            }
        }
    }

    public static boolean isMagicSquare (int[][] ms) {

        int num = 0;
        for (int i = 0; i < ms.length; i++) {
            num+= ms[0][i];
        }

        //testing rows
        int rows = 0;
        for (int k = 1; k < ms.length; k++) {
            for (int j = 0; j < ms.length; j++) {
                rows+= ms[k][j];
            }
            if (rows != num) {
                return false;
            }
            else {
                rows = 0;
            }
        }

        //testing columns
        int columns = 0;
        for (int k = 0; k < ms.length; k++) {
            for (int j = 0; j < ms.length; j++) {
                columns+= ms[j][k];
            }
            if (columns != num) {
                return false;
            }
            else {
                columns = 0;
            }
        }

        //testing diagonal starting left
        int lDiag = 0;
        for (int k = 0; k < ms.length; k++) {
            lDiag += ms[k][k];
        }
        if (lDiag != num) {
            return false;
        }

        //testing diagonal starting right
        int rDiag = 0;
        for (int k = 0; k < ms.length; k++) {
            rDiag += ms[k][-1*k+(ms.length-1)];
        }
        if (rDiag != num) {
            return false;
        }
        return true;
    }


    public static int countInRange(int[] lis, int min, int max) {
        int count = 0;
        for (int i : lis) {
            if (i <= max) {
                if (i >= min) {
                    count++;
                }
            }
        }

        return count;
    }

}
