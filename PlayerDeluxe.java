import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerDeluxe {

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
//        // The name you want
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a name:");
//
//        // Read a line of text from the command line
//        String input = scanner.nextLine();

        String input = args[0];

        String[] fifteen = readFile("1500east.txt");
        String[] eight = readFile("800east.txt");
        String[] steeple = readFile("3000seast.txt");


        List list1 = new List(fifteen, "1500");
        List list2 = new List(eight, "800");
        List list3 = new List(steeple, "steeple");

        List[] lists = {list1, list2, list3};

        Player player = new Player(input);
        player.all(lists);

        System.out.println(player.name + "'s Best Event = " + player.bestEventName());
        System.out.println(player.bestEvent.event + " rank = " + player.bestRank());



    }
}
