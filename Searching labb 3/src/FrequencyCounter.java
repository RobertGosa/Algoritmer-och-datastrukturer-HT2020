import java.util.Scanner;

public class FrequencyCounter {

    public static void main(String args[]) {
        int distinct = 0, words = 0, N = 5, minlen = 5;
        Scanner scan = new Scanner(System.in);
        String[] input = new String[N * 100];
        int posCounter = 0, wordCounter = 0;
        /*while(scan.hasNext() && wordCounter < N * 100){
            String next = scan.next();
            //System.out.println(next + " " + next.length());
            if (next.length() < minlen){
                wordCounter++;
                continue;
            }
            input[posCounter++] = next;
            wordCounter++;
            System.out.println("Position " + (posCounter-1) + " " + input[posCounter-1]);
        }
        System.out.println("");*/
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        // compute frequency counts
        while (scan.hasNext() && wordCounter < N * 100) {
            String key = scan.next();
            if (key.length() < minlen){ //if word too short, skip
                wordCounter++;
                continue;
            }
            words++;
            if (st.contains(key)) { //if already in the array
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
            input[posCounter++] = key;
            wordCounter++;
        }

        /*Comparable[] keys = st.getKeys();
        for(int i = 0; i < keys.length; i++){
            System.out.println("Key: " + keys[i]);
        }
        for(int i = 0; i < keys.length; i++){
            System.out.println("Input: " + input[i] + " Number: " + i);
        }*/

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (int j = 0; j < posCounter; j++){
            String key = input[j];
            //System.out.println("Input is: " + key + " Number: " + j);
            //System.out.println("The key: " + st.get(key));
            if (st.get(key) > st.get(max))
                max = key;
        }

        System.out.println("Most frequent word is \"" + max + "\" and it is used " + st.get(max) + " times");
        System.out.println("Distinct words = " + distinct);
        System.out.println("Total words    = " + words);
    }
}
