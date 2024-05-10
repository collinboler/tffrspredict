import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// take a
public class NameExtract {

    private static void nameExtract(String input) {
        String[] rawEntries = ReadFile.readFile(input + "eastraw.txt");

        String[] fullNames = extractFullNames(rawEntries);

//
//        for (String line : fullNames) {
//            System.out.println(line);
//        }
//        writeToFile(fullNames, newFile);
    }

    // read array and create a String[] with extracted names

        private static String[] extractFullNames (String[] entries){
            if (entries == null) return new String[0]; // Handle null input gracefully

            String[] fullNames = new String[entries.length];
            int index = 0;

            for (String entry : entries) {
                if (entry != null && !entry.isEmpty()) {
                    String[] parts = entry.split("\t"); // Split by tab
                    if (parts.length > 1) {
                        String namePart = parts[1]; // Assuming the name part is the second element
                        String[] nameParts = namePart.split(" "); // Split by space to isolate last and first names
                        if (nameParts.length > 1) {
                            String lastName = nameParts[0].trim();
                            String firstName = nameParts[1].trim();
                            fullNames[index++] = lastName + " " + firstName;
                        }
                    }
                }
            }
            // Resize the array to match the number of valid names extracted
            return Arrays.copyOf(fullNames, index);
        }



        // write from array to file
        private static void writeToFile (String[]entries, String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String line : entries) {
                    writer.write(line);
                    writer.newLine();  // Writes a new line
                }
                System.out.println("Data written to file " + filename + " successfully.");
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file " + filename + "; " + e.getMessage());
            }
        }

        public static void main (String[]args) {
            //examples
            // you can choose 800, 1500, 5000, 10000, or steeple.
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for the type of input they want to process
            System.out.println("Make sure the raw file is in raw.txt");
            System.out.println("Input 800, 1500, 5000, 10000, or steeple");
            String input = scanner.nextLine();

            scanner.close();

//            String input = args[0];

            String[] rawEntries = ReadFile.readFile("raw.txt");

            String[] fullNames = extractFullNames(rawEntries);

            for (String line : fullNames) {
                System.out.println(line);
            }
            writeToFile(fullNames, input + "east.txt");

        }
    }


