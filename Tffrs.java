import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Queue;


public class Tffrs {
    private String event;
    public static Player[] playerRead(String[] players, String eventName) {

        boolean five = false;
        if (Objects.equals(eventName, "5000")) {
           five = true;
        }

        Queue<Player> playerQueue = new LinkedList<Player>();
        for (int i = 0; i < players.length; i++) {
           Player player = playerFill(players[i], five);
           if (Objects.equals(player.bestEventName(), eventName)){
               playerQueue.add(player);
           }
        }

         return playerQueue.stream().toArray(Player[]::new);

    }
    public static Player playerFill(String input, boolean five) {
        String[] fifteen = readFile("1500east.txt");
        String[] eight = readFile("800east.txt");
        String[] steeple = readFile("steepleeast.txt");
        String[] fivek = readFile("5000east.txt");
        String[] four = readFile("400east.txt");
        String[] ten = readFile("10000east.txt");

        List list1500 = new List(fifteen, "1500");
        List list800 = new List(eight, "800");
        List list3000s = new List(steeple, "steeple");
        List list5000 = new List(fivek, "5000");
        List list400 = new List(four, "400");
        List list10000 = new List(ten, "10000");





        Player player = new Player(input);
        List[] lists = {list1500, list800, list3000s, list5000, list400, list10000};

        // if event is 5K, don't consider 10K standings
        if (five) {
            List [] fiveklists = {list1500, list800, list3000s, list5000, list400};
            player.all(fiveklists);
            return player;
        }

        player.all(lists);
        return player;
    }

    public static String[] readFile(String filename) {
        ArrayList<String> data = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data.toArray(new String[0]);
    }

    public static void main(String[] args) {
       // read in names from single event
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to tffrs predict!");

        // Prompt the user for the type of input they want to process
        System.out.println();
        System.out.println("This program considers the 400, 800, 1500, 5000, 10000, and the steeple");
        System.out.println("Which event would you like to predict?");
        System.out.println();
        String input = scanner.nextLine();

        scanner.close();

        String[] event = readFile(input + "east.txt");
        Player[] list = playerRead(event, input);

        System.out.println("Estimated " + input + " Standings:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + 1 + " " + list[i].name);
            if (i == 47) System.out.print(" " + "[current rank: " + list[i].bestRank() + "]");
            System.out.println();
        }

    }
}
