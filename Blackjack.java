import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


//Dev notes
/*
All player data is kept in data
The index corresponds to the player number
Each index in data is an ArrayList<Integer> with format {standBit, card1, card2, ...}, this is called playerData
standBit is 1 by default, 0 if the player is standing or is out

Already drawn cards are in drawn. Newly generated cards are ensured to be available. There are 4 of every card in a deck.

checkAlive() -> true if there is still a player left in the game, else false
count() -> takes in playerData and counts the sum of cards, returns lower sum and higher sum as int[] (for ace cards). If there are no aces they are equal.
printDeck() -> prints playerData cards
 */

// Stand bit, 1 = in, 0 = out

public class Blackjack {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        System.out.println("Blackjack multiplayer");
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players? ");
        int players = sc.nextInt();
        sc.nextLine();
        System.out.println("Press ENTER to start");
        sc.nextLine();

        ArrayList<Integer> money = new ArrayList<>();

        for (int i = 0; i < players; i++) {
            money.add(200);
        }

        // one game, all logic
        do {

            ArrayList<Integer> moneySnapshot = new ArrayList<>(money);
            int totalBet = 0;

            for (int i = 0; i < players; i++) {
                System.out.println("Player " + (i+1) + ": $"  + money.get(i));
            }

            for (int i = 0; i < players; i++) {
                System.out.println("Player " + (i+1) + ", enter your bet: ");
                int bet = sc.nextInt();
                if (money.get(i) - bet < 0) {
                    System.out.println("That bet is too large, enter again: ");
                    bet = sc.nextInt();
                }
                sc.nextLine();
                money.set(i, money.get(i) - bet);
                totalBet += bet;
            }
            System.out.println();

            ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>(); // player data
            ArrayList<Integer> drawn = new ArrayList<Integer>(); // drawn cards

            // initialize all player decks
            for (int i = 0; i < players; i++) {
                ArrayList<Integer> playerData = new ArrayList<Integer>();
                playerData.add(1); // stand bit
                int a = r.nextInt(0, 13) + 1;
                int b = r.nextInt(0, 13) + 1;
                drawn.add(a);
                drawn.add(b);
                playerData.add(a);
                playerData.add(b);
                data.add(playerData);

            }

            boolean blackjack = false;


            // player loop until all players have standed or are out
            while (checkAlive(data)) {

                // prompt every player in succession
                for (int i = 0; i < players; i++) {

                    // skip player if they are out
                    if (data.get(i).get(0) == 0) {
                        continue;
                    }

                    System.out.println("PLAYER " + (i + 1));
                    System.out.println("________");
                    printDeck(data.get(i));

                    int[] sum = count(data.get(i));

                    if (sum[0] != sum[1]) {
                        System.out.println("Sum: " + sum[0] + " or " + sum[1]);
                    } else {
                        System.out.println("Sum:" + sum[0]);
                    }

                    System.out.println();
                    String action = "";
                    while (!action.equals("hit") && !action.equals("stand")) {
                        System.out.println("What is your action? (hit, stand)");
                        action = sc.nextLine();
                    }

                    if (action.equals("hit")) {

                        // generate next card
                        int next = r.nextInt(0, 13) + 1;
                        while (Collections.frequency(drawn, next) >= 4) {
                            next = r.nextInt(0, 13) + 1; // regenerate until card is available
                        }
                        data.get(i).add(next); // add card to playerData
                        drawn.add(next); // add card to drawn cards
                        System.out.println("Your deck is now:");
                        printDeck(data.get(i));

                        if (count(data.get(i))[0] > 21) { // if lower sum is greater than 21, then player is out
                            System.out.println("You're out!");
                            data.get(i).set(0, 0); // set stand bit to 0
                        }

                        if (count(data.get(i))[0] == 21 || count(data.get(i))[1] == 21) { // if either sum is 21, then auto win
                            System.out.println("Player " + (i + 1) + " won!");
                            int gain = (int) (totalBet + (totalBet * 1.5));
                            System.out.println("Player " + (i + 1) + " gained " + gain + " dollars!");
                            money.set(i, money.get(i) + gain);
                            System.out.println("Player " + (i + 1) + " now has " + "$" + money.get(i));
                            blackjack = true;
                        }

                        // ending messages
                        if (checkAlive(data)) {
                            if (players > 1) { // only print next player message if there is more than one player
                                System.out.println("Moving on to the next player");
                            }
                        } else {
                            System.out.println("Moving on to the dealer");
                        }
                        System.out.println();
                    } else if (action.equals("stand")) {
                        data.get(i).set(0, 0); // set stand bit to 0
                        if (checkAlive(data)) {
                            if (players > 1) {
                                System.out.println("Moving on to the next player");
                            }
                        } else {
                            System.out.println("Moving on to the dealer");
                        }
                        System.out.println();
                    }
                }
            }

            if (blackjack) {
                break;
            }

            Thread.sleep(1500);

            ArrayList<Integer> endValues = new ArrayList<Integer>();

            // calculate the sums for every player
            for (int i = 0; i < players; i++) {
                int a = count(data.get(i))[0];
                int b = count(data.get(i))[1];

                if (a > 21) {
                    endValues.add(-1);
                    continue;
                }

                if (b <= 21) {
                    endValues.add(Math.max(a, b));
                } else {
                    endValues.add(a);
                }
            }

            int largestValue = Collections.max(endValues); // player with the largest value, to be compared to the dealer

            ArrayList<Integer> dealerDeck = new ArrayList<Integer>(); // dealerDeck, same format as playerData

            // generate two cards
            int nextA = r.nextInt(0, 13) + 1;
            while (Collections.frequency(drawn, nextA) >= 4) {
                nextA = r.nextInt(0, 13) + 1;
            }
            drawn.add(nextA);
            int nextB = r.nextInt(0, 13) + 1;
            while (Collections.frequency(drawn, nextB) >= 4) {
                nextB = r.nextInt(0, 13) + 1;
            }
            drawn.add(nextB);

            dealerDeck.add(1);
            dealerDeck.add(nextA);
            dealerDeck.add(nextB);


            // dealer AI, hits until they are greater than the max player value
            while (true) {
                System.out.println("DEALER");
                System.out.println("______");
                printDeck(dealerDeck);
                int[] sum = count(dealerDeck);

                if (sum[0] != sum[1]) {
                    System.out.println("Sum: " + sum[0] + " or " + sum[1]);
                } else {
                    System.out.println("Sum:" + sum[0]);
                }

                System.out.println();

                if (sum[0] > 21) {
                    System.out.println("The dealer is out!");
                    break;
                }

                if (sum[0] > largestValue || sum[1] > largestValue) {
                    System.out.println("The dealer is standing");
                    break;
                } else {
                    System.out.println("The dealer is hitting");
                    int next = r.nextInt(0, 13) + 1;
                    while (Collections.frequency(drawn, next) >= 4) {
                        next = r.nextInt(0, 13) + 1;
                    }
                    dealerDeck.add(next);
                    drawn.add(next);
                }
                Thread.sleep(1500);
            }

            int dealerValue = -1;
            int a = count(dealerDeck)[0];
            int b = count(dealerDeck)[1];


            if (b <= 21) {
                dealerValue = Math.max(a, b);
            } else {
                dealerValue = a;
            }

            if (a > 21) {
                dealerValue = -1;
            }


            if (largestValue > dealerValue) {
                if (Collections.frequency(endValues, largestValue) > 1) {
                    System.out.println("Tie");
                    money = moneySnapshot;
                } else {
                    int playerIndex = endValues.indexOf(largestValue);
                    System.out.println("Player " + (playerIndex + 1) + " wins!");
                    int gain = (int) (totalBet + (totalBet * 1.5));
                    System.out.println("Player " + (playerIndex + 1) + " gained " + gain + " dollars!");
                    money.set(playerIndex, money.get(playerIndex) + gain);
                    System.out.println("Player " + (playerIndex + 1) + " now has " + "$" + money.get(playerIndex));

                }
            } else if (largestValue == dealerValue) {
                if (Collections.frequency(endValues, largestValue) > 1) {
                    System.out.println("Tie");
                    money = moneySnapshot;
                } else {
                    System.out.println("Player " + (endValues.indexOf(largestValue) + 1) + " wins!");
                    int playerIndex = endValues.indexOf(largestValue);
                    int gain = (int) (totalBet + (totalBet * 1.5));
                    System.out.println("Player " + (playerIndex + 1) + " gained " + gain + " dollars!");
                    money.set(playerIndex, money.get(playerIndex) + gain);
                    System.out.println("Player " + (playerIndex + 1) + " now has " + "$" + money.get(playerIndex));
                }
            } else {
                System.out.println("The dealer wins!");
            }
        } while (playAgain());
    }

    public static boolean playAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wish to play again? (yes, no)");

        String input = sc.nextLine();
        while (!input.equals("yes") && !input.equals("no")) {
            System.out.println("Do you wish to play again? (yes, no)");
            input = sc.nextLine();
        }

        if (input.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] count(ArrayList<Integer> cards) {

        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i < cards.size(); i++) {

            if (cards.get(i) == 1) {
                sumA += 1;
                sumB += 10;
            } else if (cards.get(i) == 11 || cards.get(i) == 12 || cards.get(i) == 13) {
                sumA += 10;
                sumB += 10;
            } else {
                sumA += cards.get(i);
                sumB += cards.get(i);
            }
        }

        if (sumB > 21) { // sumB will always be bigger than sumA, so if its bigger than 21 then exclude it
            sumB = sumA;
        }

        int[] ret = {Math.min(sumA, sumB), Math.max(sumA, sumB)};
        return ret;
    }

    public static void printDeck(ArrayList<Integer> cards) {
        for (int j = 1; j < cards.size(); j++) {
            int card = cards.get(j);
            if (card == 1) {
                System.out.print("A ");
            } else if (card == 11) {
                System.out.print("J ");
            } else if (card == 12) {
                System.out.print("Q ");
            } else if (card == 13) {
                System.out.print("K ");
            } else {
                System.out.print(card + " ");
            }
        }
        System.out.println();
    }

    public static boolean checkAlive(ArrayList<ArrayList<Integer>> data) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).get(0) == 1) {
                return true;
            }
        }
        return false;
    }
}
