package com.company;

import java.util.Scanner;

public class Uppgift6OrderedQueue {
    //Prints messages with instructions to the console and informs the user of what data is expected. Also calls the functions using the data
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
