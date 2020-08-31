package com.company;

import java.util.Scanner;

public class Uppgift3FIFOQueue {

    public static void doubleLinkedCircularList(){
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        char action;
        int item;

        while(flag){
            System.out.println("What is the next action? Add (a) / Remove (r) / Finish (f)");
            action = scan.next().charAt(0);
            switch (action) {
                case 'a':
                    System.out.println("Insert value:");
                    item = scan.nextInt();
                    queue.enqueue(item);
                    break;
                case 'r':
                    System.out.println("Removed value: " + queue.dequeue());
                    break;
                case 'f':
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a valid answer. Try again!");
            }

        }

    }

}
