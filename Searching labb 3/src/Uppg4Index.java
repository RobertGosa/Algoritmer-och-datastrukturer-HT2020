import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uppg4Index {
    public static int position = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File file = new File("C:\\Users\\rober\\IdeaProjects\\Searching labb 3\\FilteredText.txt");
        Scanner input = new Scanner(file); //file scanner
        Scanner scan = new Scanner(System.in); //console scanner

        BinarySearchST<String, List> st = new BinarySearchST<>();
        StringBuilder theWholeText = new StringBuilder(); //empty stringbuilder

        System.out.println("What word would you like to find? ");
        String wordToFind = scan.nextLine(); //scan the word to find from console


        while(input.hasNextLine()){
            theWholeText.append(input.nextLine().toLowerCase()); //add line to the stringbuilder
        }

        int charCounter;
        int wordCounter = 0;
        int totalWords = 141491;
        while(wordCounter < totalWords) { //while word counter is less than total words
            int blanks = 0; //blank character counter
            StringBuilder word = new StringBuilder();
            while(position < theWholeText.length()){
                if(theWholeText.charAt(position) == ' '){ //if the character is a blank
                    while(theWholeText.charAt(position) == ' '){ //while is keeps beeing a plank
                        blanks++;
                        position++;
                    }
                    break;
                }
                else{ //if it is not a blank, append each character to the word builder
                    word.append(theWholeText.charAt(position));
                    position++;
                }
            }
            String key = word.toString(); //use the word as the key
            charCounter = 1 + position - blanks - key.length(); //the position of the key is starting at 1 plus the position counter minus the blank characters after the word and the word length

            if (st.contains(key)) {  //if word has appeared before
                List alreadyExistingList = st.get(key); //get the list with the positions of the word
                alreadyExistingList.add(charCounter); //add new position
                st.put(key, alreadyExistingList);  //update
            }
            else { //if the word does not yet exist
                List newList = new ArrayList(); //create a new list
                newList.add(charCounter); //add the value to the list
                st.put(key, newList);  //put the list in the table
            }
            wordCounter++;
        }

        if(st.contains(wordToFind)){ //if the word to find is in the table, print how many times it was found and at what positions
            System.out.println("Word was found " + st.get(wordToFind).size() +
                    " times at positions: " + st.get(wordToFind));
        }
        else //print that the word was not found
            System.out.println("Word was not found");
    }
}