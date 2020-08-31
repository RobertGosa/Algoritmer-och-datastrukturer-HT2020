package com.company;

import java.util.Scanner;

public class Uppgift2Recursive {

    static Stack<Character> stack = new Stack<>();
    static Scanner scan = new Scanner(System.in);
    static String input = scan.nextLine() + '\n';
    static char c = ' ';
    static int counter = 0;

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

