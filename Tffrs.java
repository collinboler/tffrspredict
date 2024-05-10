import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Queue;


public class Tffrs {


    public static String[] playerRead(String[] players, String eventName) {
        int count;
        Queue<Player> playerQueue = new LinkedList<Player>();
        for (int i = 0; i < players.length; i++) {
           Player player = playerFill(players[i]);
           if (Objects.equals(player.bestEventName(), eventName)){
               playerQueue.add(player);
           }
        }

        Player[] playerArray = playerQueue.stream().toArray(Player[]::new);

        String[] newArray = new String[playerArray.length];
        for (int i = 0; i < playerArray.length; i++) {
            newArray[i] = playerArray[i].name;
        }

        return newArray;
    }
    public static Player playerFill(String input) {
        String[] fifteen = readFile("1500east.txt");
        String[] eight = readFile("800east.txt");
        String[] steeple = readFile("steepleeast.txt");
        String[] fivek = readFile("5000east.txt");

        List list1 = new List(fifteen, "1500");
        List list2 = new List(eight, "800");
        List list3 = new List(steeple, "steeple");
        List list4 = new List(fivek, "5000");

        List[] lists = {list1, list2, list3, list4};

        Player player = new Player(input);
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

        // Prompt the user for the type of input they want to process
        System.out.println();
        System.out.println("This program considers 800, 1500, 5000, or steeple (no 10000 rn)");
        System.out.println("Input 800, 1500, 5000, or steeple");
        String input = scanner.nextLine();

        scanner.close();

        String[] event = readFile(input + "east.txt");
        String[] list = playerRead(event, input);

        System.out.println("Estimated " + input + " Standings:");
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + 1 + " " + list[i]);
        }

    }
}
