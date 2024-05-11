import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Refresh {
    public static void refresh(String input, String[] stringArray) {
        String[] refreshed = new String[input.length()];
        refreshed = NameExtract.extractFullNames(stringArray);
        clearFile(input + "east.txt");
        NameExtract.writeToFile(refreshed, input + "east.txt");
        clearFile("raw.txt");
    }


        public static void clearFile(String filename) {
            try (PrintWriter writer = new PrintWriter(filename)) {
                // By creating a PrintWriter object without appending (which is default),
                // it will clear the file automatically.
            } catch (FileNotFoundException e) {
                System.err.println("Error: The file could not be found.");
            }
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make sure the new entries are in raw.txt");
        System.out.println("Which event would you like to update? 800 ~ 1500 ~ 5000 ~ 10000 ~ steeple");
        String eventUpdate = scanner.nextLine();

        String[] rawEntries = ReadFile.readFile("raw.txt");

        Refresh.refresh(eventUpdate, rawEntries);

        scanner.close();
        }

    }


