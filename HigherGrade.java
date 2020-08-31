package com.company;

import java.util.Scanner;

public class HigherGrade {

    public static void balancedParanthesis(){
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("Enter some text with paranthesis: ");
        String text = scan.next();
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(' || text.charAt(i) == '[' || text.charAt(i) == '{'){
                stack.push(text.charAt(i));
            }
            if(text.charAt(i) == ')' || text.charAt(i) == ']' || text.charAt(i) == '}'){
                if(stack.areOpposites(stack.peek(), text.charAt(i))) {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("Paranthesis are balanced!");
        } else {
            System.out.println("Paranthesis are not balanced!");
        }
    }
}
