import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

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

        Player[] playerArray = playerQueue.stream().toArray(Player[]::new);

        return playerArray;
    }

    public static void main(String[] args) {
        String input = args[0];


        String[] event = ReadFile.readFile(input + "east.txt");
        Player[] list = playerRead2(event, input);

        System.out.println(input + " Analysis:");
        for (int i = 0; i < list.length; i++) {
            Player player = list[i];
            System.out.println(i + 1 + " " + player.name + " " +
                    "(#" + player.bestRank() + ")" +
                    " --> " + player.eventNum + " event(s)");
        }


    }
}
