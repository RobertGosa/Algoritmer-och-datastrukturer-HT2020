package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Uppgift2Iterative {

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
