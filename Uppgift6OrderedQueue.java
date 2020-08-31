package com.company;

import java.util.Scanner;

public class Uppgift6OrderedQueue {

    public static void doubleLinkedCircularList(){
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int item;

        while(true){
            System.out.println("What value do you want to add?");
            item = scan.nextInt();
            queue.enqueueInOrder(item);
        }

    }
}
