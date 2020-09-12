package com.company;

import java.util.Scanner;

// Checks if the parentheses in a given input are balanced
public class HigherGrade {

    /**
     * Pushes all the opening parentheses in a given input to a stack and pops from the stack if the next closing parenthesis is following the right opening one
     */
    public static void balancedParentheses(){
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("Enter some text with parentheses: ");
        String text = scan.next();
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(' || text.charAt(i) == '[' || text.charAt(i) == '{'){
                stack.push(text.charAt(i));
            }
            if(text.charAt(i) == ')' || text.charAt(i) == ']' || text.charAt(i) == '}'){
                if(stack.isEmpty()){
                    System.out.println("Parentheses are not balanced!");
                    return;
                }
                if(stack.areOpposites(stack.peek(), text.charAt(i))) {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("Parentheses are balanced!");
        } else {
            System.out.println("Parentheses are not balanced!");
        }
    }
}
