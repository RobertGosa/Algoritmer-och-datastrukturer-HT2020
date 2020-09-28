import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HigherGrade{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\rober\\IdeaProjects\\Searching labb 3\\leipzig1mFiltered.txt");
        Scanner input = new Scanner(file); //file scanner
        Scanner scan = new Scanner(System.in); //console scanner
        Quicksort quicksort = new Quicksort();
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();

        int distinctWords = 0;
        long startTime = System.currentTimeMillis();
        while(input.hasNext()) { //while the text has more words
            String key = input.next().toLowerCase();
            if (key.length() < 1) continue; //if word is too short, skip

            if (st.contains(key)) {  //if word already exists
                st.put(key, st.get(key) + 1);  //update the value
            }
            else {
                st.put(key, 1);  //make a new key with value 1
                distinctWords++;
            }
        }

        String keys[] = new String[distinctWords]; //make arrays to sort later
        Integer vals[] = new Integer[distinctWords]; //make arrays to sort later

        int a = 0;
        for (String key : st.keys()){ //fill the key array with the keys
            keys[a] = key;
            a++;
        }

        int b = 0;
        for (Integer value : st.values()) { //fill the values array with the values
            vals[b] = value * -1;
            b++;
        }

        quicksort.sort(vals, keys); //sort the arrays using quick sort
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Distinct words: " + formatBigNumbers(distinctWords));
        System.out.println("Time taken to build all the data structures: " + totalTime/1000 + " seconds");
        while(true){ //endless loop
            System.out.println("Which positions do you want to see? Enter two values, ex. 1 10 (for positions 1 to 10). Enter the value twice for only one position, ex. 10 10 (for just position 10)");
            int start = scan.nextInt(); //scan start position
            int end = scan.nextInt(); //scan end position

            for(int i = start; i <= end; i++) //for every given position, print
                System.out.println("Position " + i + " has value \"" + keys[i-1] + "\" and is found " + formatBigNumbers(vals[i-1]*-1) + " time(s) in the text.");
        }
    }

    /**
     * Makes 1000000 look like 1,000,000
     * @param bigNumber the number to be formatted
     */
    public static StringBuilder formatBigNumbers(long bigNumber) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;

        while (bigNumber > 0) {
            sb.insert(0, bigNumber % 10 );
            bigNumber = bigNumber / 10;
            if(counter == 3){
                sb.insert(0, ",");
                counter = 0;
            }
            counter++;
        }
        if(sb.indexOf(",") == 0) {
            sb.delete(0,1);
        }
        return sb;
    }

}
