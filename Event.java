import java.util.Objects;

public class Event {
    public String player;
    public String event;
    public int rank;
    public boolean ranked;


    public Event(String eventName, String playerName, String[] list) {
        this.player = playerName;
        this.event = eventName;
        this.ranked = false;

        for (int i = 0; i < list.length; i++) {
            if (Objects.equals(list[i], player)) {
                this.rank = i + 1;
                this.ranked = true;
                break;
            }
        }

    }


    public static void main(String[] args) {

    }


}
