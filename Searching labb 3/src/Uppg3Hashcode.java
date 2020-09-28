import java.util.Scanner;

public class Uppg3Hashcode {

    public static void main(String[] args) {
        int M = 9944; //hash values are between 0 and M-1
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>(M);

        while (scan.hasNext()) { //as long as there are more words
            String word = scan.next().toLowerCase(); //scan the next word
            st.put(word, 1); //put the word in the table
        }

        for (int position = 0; position < M; position++) {
            System.out.println("Position number " + position + " has size: " + st.listSize(position));
        }

    }
}