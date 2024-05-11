import java.util.Queue;

public class QueuetoArray {
    // convert Queue of String[] to single String[]
    public static String[] queuetoArray(Queue<String[]> file) {
        // determine total number of strings
        int totalSize = 0;
        for (String[] array : file) {
            totalSize += array.length;
        }
        // create new array that can hold all strings
        String[] combinedArray = new String[totalSize];

        // Copy all strings from the queue to the new array
        int index = 0;
        for (String[] array : file) {
            for (String str : array) {
                combinedArray[index++] = str;
            }
        }
        return combinedArray;
    }
    public static void main(String[] args) {

    }
}
