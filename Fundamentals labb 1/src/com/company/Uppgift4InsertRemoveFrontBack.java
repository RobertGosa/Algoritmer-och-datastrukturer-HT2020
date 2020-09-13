package com.company;

import java.util.Scanner;

public class Uppgift4InsertRemoveFrontBack {
    //Prints messages with instructions to the console and informs the user of what data is expected. Also calls the functions using the data
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
                    System.out.println("Add to front (f) or end (e)?");
                    action = scan.next().charAt(0);
                    System.out.println("Insert value:");
                    item = scan.nextInt();
                    switch (action){
                        case 'f':
                            queue.enqueueToFront(item);
                            break;
                        case 'e':
                            queue.enqueue(item);
                            break;
                    }
                    break;
                case 'r':
                    System.out.println("Remove from front (f) or end (e)?");
                    action = scan.next().charAt(0);
                    switch (action){
                        case 'f':
                            System.out.println("Removed value: " + queue.dequeue());
                            break;
                        case 'e':
                            System.out.println("Removed value: " + queue.dequeueFromEnd());
                            break;
                    }
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
