import java.util.Scanner;

public class Uppg2FrequencyCounter {

    public static void main(String args[]) {
        int distinctWords = 0, minlen = 1, totalWords = 0, N = 20000;
        Scanner scan = new Scanner(System.in);
        //BST<String, Integer> st = new BST<String, Integer>();
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(141492);
        long startTime1, startTime2, totalTime1 = 0, totalTime2 = 0;
            while (scan.hasNext() && totalWords < N * 100) { // while we there is more text and we have not exceeded the limit
                String key = scan.next().toLowerCase(); //scan words as lower case to avoid "The" and "the" being different words
                if (key.length() < minlen) { //if the word is too short, skip
                    totalWords++;
                    continue;
                }
                if (st.contains(key)) { //if the word already exists
                    int theKey = st.get(key);
                    startTime1 = System.nanoTime();
                    st.put(key,  theKey + 1); //increment the value
                    totalTime1 += System.nanoTime() - startTime1;
                } else {
                    startTime1 = System.nanoTime();
                    st.put(key, 1); //make a new key with value 1
                    totalTime1 += System.nanoTime() - startTime1;
                    distinctWords++;
                }
                totalWords++;
            }

        String mostFrequent = "";
        st.put(mostFrequent, 0);
            for (String key : st.keys()){ //for every key
                startTime2 = System.nanoTime();
                Integer theKey = st.get(key);
                totalTime2 += System.nanoTime() - startTime2;
                if (theKey > st.get(mostFrequent)) //compare with largest value
                    mostFrequent = key; //update most frequent
            }
                //System.out.println("Attempt number " + i + " with " + formatBigNumbers(N * 100) + " words took " + formatBigNumbers(totalTime2) + "ns");
                //System.out.println(totalTime2 / 1_000_000 + " " + N);

        System.out.println("Most frequent word with min length " + minlen + " is \"" + mostFrequent + "\" and it is used " + st.get(mostFrequent) + " times");
        System.out.println("Distinct words = " + formatBigNumbers(distinctWords)); //with length more than minlen
        System.out.println("Total words    = " + formatBigNumbers(totalWords));
        System.out.println("Total time     = " + formatBigNumbers(totalTime2) + "ns");
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
