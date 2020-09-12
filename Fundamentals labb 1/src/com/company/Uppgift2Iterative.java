package com.company;

import java.util.Scanner;

//Prints messages with instructions to the console and informs the user of what data is expected. Also calls the functions using the data
public class Uppgift2Iterative {

    /**
     * Iterative method that reverses the characters of an input using a stack and prints the result
     */
    public static void reverseChars() {
        Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String input = scan.nextLine() + '\n';
        char c = ' ';
        int counter = 0;
        while(c != '\n'){
            c = input.charAt(counter);
            if(c != '\n') {
                stack.push(c);
            }
            counter++;
        }

        System.out.println(stack.toString());

    }

}
