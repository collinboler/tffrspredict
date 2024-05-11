public class Player {
    public String name;
    public int eventNum;
    public Event bestEvent;


    public Player(String name) {
        this.name = name;
   }

   public void all(List[] lists) {
        for (int i = 0; i < lists.length; i++) {
            List list = lists[i];
            rank(list.actualList, list.name);
        }

   }
   public String bestEventName() {
       return bestEvent.event;
   }

   public int numEvents() {
        return eventNum;
   }

   public int bestRank() {
        return bestEvent.rank;
   }

   public void rank(String[] list, String eventName) {
        Event event = new Event(eventName, this.name, list);
        if (event.ranked) {
            if (eventNum == 0)  {
                bestEvent = event;
                eventNum++;
                return;
            }
            if (event.rank < bestEvent.rank)  {
                bestEvent = event;
            }
            eventNum++;
        }

   }
    public static void main(String[] args) {
        String[] fifteen = {"Witt", "Boler", "Chunks", "Monte" };
        String[] eight = {"Rodman", "Witt", "Monte", "Chunks" };
        String[] steeple = {"Jug", "Monte", "Chunks"};

       List list1 = new List(fifteen, "1500");
       List list2 = new List(eight, "800");
       List list3 = new List(steeple, "steeple");
//
//       Player Witt = new Player("Witt");
//       Witt.all(list1, list2, list3);
//
//       System.out.println("Witt's Best Event = " + Witt.bestEventName());
//        System.out.println(Witt.bestEvent.event + " rank = " + Witt.bestRank());
//


    }



    }

