import java.util.*;

public class Madlib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me a name: ");
        String name = sc.nextLine();
        System.out.println("Give me a positive integer: ");
        int hours = sc.nextInt();
        sc.nextLine();
        System.out.println("Give me a verb ending in -ing: ");
        String verb = sc.nextLine();
        System.out.println("Give me a name: ");
        String name2 = sc.nextLine();
        System.out.println("Give me an adverb: ");
        String adverb = sc.nextLine();
        System.out.println("Give me a noun: ");
        String noun2 = sc.nextLine();
        System.out.println("Give me an adjective: ");
        String adj = sc.nextLine();
        System.out.println("Give me a verb ending in -ing:");
        String verb2 = sc.nextLine();
        System.out.println("Give me a name of a building or room: ");
        String building = sc.nextLine();
        System.out.println("Give me a positive integer: ");
        int minutes = sc.nextInt();
        sc.nextLine();
        System.out.println("Give me a location:");
        String location = sc.nextLine();



    System.out.print(name + " spent the last " + hours + " hours " + verb + " and still isn't done. " + name2 + " entered and saw " + name + " " + verb + " " + adverb + ".\n" + name + " had wasted " + hours + " hours to only obtain a "
    + noun2 + ". " + name2 + " thought " + name + " was very " + adj + ". " + name + " did not.\nThey took turns " + verb2 + " at each other until finally " + name2 + " left the " + building + " and left " + name + " to his own devices.\n" + name2 + " travelled for " + minutes + " minutes to "
    + location + ". To " + name2 + "'s surprise, " + name + " was there waiting. Finally, " + name + " had stopped " + verb + " and is actually doing something else.");
    }
}
