public class MicePopulationSimulation {
    public static void main(String[] args) {
        int currentYear = 0;
        for (int mice = 3; mice <= 4000; mice *= 2, currentYear++){}
        System.out.println(currentYear);

    }
}
