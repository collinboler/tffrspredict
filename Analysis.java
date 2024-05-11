import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Analysis {
//    public static void analyze(String playerName) {
//        Player player = Tffrs.playerFill(playerName);
//
//        System.out.print(player.name + " " + player.bestEventName() +
//                "(#" + player.bestRank() + ")" +
//                " --> " + player.eventNum + " event(s)");
//    }

    public static Player[] playerRead2(String[] players, String eventName) {
        boolean five = false;
        if (Objects.equals(eventName, "5000")) {
            five = true;
        }

        Queue<Player> playerQueue = new LinkedList<Player>();
        for (int i = 0; i < players.length; i++) {
            Player player = Tffrs.playerFill(players[i], five);
            if (Objects.equals(player.bestEventName(), eventName)){
                playerQueue.add(player);
            }
        }

        return playerQueue.stream().toArray(Player[]::new);

    }

    public static Player[] scratched(String[] players, String eventName) {
        boolean five = false;
        if (Objects.equals(eventName, "5000")) {
            five = true;
        }

        Queue<Player> scratchQueue = new LinkedList<Player>();
        for (int i = 0; i < players.length; i++) {
            Player player = Tffrs.playerFill(players[i], five);
            if (!Objects.equals(player.bestEventName(), eventName)){
                scratchQueue.add(player);
            }
        }

        return scratchQueue.stream().toArray(Player[]::new);

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

        Refresh.clearFile("results.txt");
        System.out.println();
        Queue<String[]> file = new LinkedList<String[]>();
        String[] event = ReadFile.readFile(input + "east.txt");
        Player[] list = playerRead2(event, input);
        Player[] scratch = scratched(event, input);

        String[] predictQ = {input + " Predicted Qualifiers:"};
        file.add(predictQ);

        String[] listP = new String[list.length];
        System.out.println(predictQ[0]);
        for (int i = 0; i < list.length; i++) {
            Player player = list[i];
            System.out.println(i + 1 + " " + player.name + " " +
                    "(#" + player.bestRank() + ")" );
            listP[i] = (i + 1 + " " + player.name + " " +
                    "(#" + player.bestRank() + ")" );
        }
        file.add(listP);


        String[] predictS = {"", input + " Predicted Scratches:"};
        file.add(predictS);
        System.out.println();
        System.out.println(predictS[1]);

        String[] scratchP = new String[scratch.length];
        for (int i = 0; i < scratch.length; i++) {
            Player player = scratch[i];
            System.out.println(i + 1 + " " + player.name + " " +
                       player.bestEventName() + "(" +  player.bestRank() + ")" );
            scratchP[i] = (i + 1 + " " + player.name + " " +
                    player.bestEventName() + "(" +  player.bestRank() + ")");
        }
        file.add(scratchP);

        String[] results = QueuetoArray.queuetoArray(file);
        // write new array to file


        NameExtract.writeToFile(results, "results.txt");
    }
}
