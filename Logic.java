import java.util.Objects;
// work in progress, going to use this to change the amount of races
// Tffrs considers based on the specific race
public class Logic {
    public static int determine(String string){
        if (Objects.equals(string, "1500")) {
            return 6;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
