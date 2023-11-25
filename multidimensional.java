public class multidimensional {
    public static void main(String[] args) {
        int[][] tab = new int[10][12];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                tab[i][j] = (i+1) * (j+1);
            }
        }

        for (int i = 0; i < tab.length; i++) {
            tab[i][6] = tab[i][2];
        }

        int[][] spec1 = new int[5][5];

        for (int i = 0; i < spec1.length; i++) {
            for (int j = 0; j < spec1[0].length; j++) {
                spec1[i][j] = (i+1)*2 * (j+1)*2;
            }
        }

        int[][] spec2 = new int[5][5];

        for (int i = 0; i < spec2.length; i++) {
            for (int j = 0; j < spec2[0].length; j++) {
                spec2[i][j] = (i+1)*2 * ((j+1)*2 - 1);
            }
        }

        printy(spec2);



    }

    public static void printy(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}
