package com.company;

import java.util.Scanner;

//Prints messages with instructions to the console and informs the user of what data is expected. Also calls the functions using the data
public class Uppgift2Recursive {

    static Stack<Character> stack = new Stack<>();
    static Scanner scan = new Scanner(System.in);
    static String input = scan.nextLine() + '\n';
    static char c = ' ';
    static int counter = 0;

    /**
     * Recursive method that reverses the characters of an input using a stack and prints the result
     */
    public static void reverseChars(){
        c = input.charAt(counter);
        if(c != '\n'){
            stack.push(c);
        }
        counter++;
            if(c != '\n'){
                reverseChars();
            } else {
                System.out.println(stack.toString());
            }
        }
    }

