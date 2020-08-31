package com.company;

import java.util.Scanner;

public class Uppgift5RemoveSpecified {

    public static void doubleLinkedCircularList() {
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        char action;
        int item, position;

        while (flag) {
            System.out.println("What is the next action? Add (a) / Remove (r) / Finish (f)");
            action = scan.next().charAt(0);
            switch (action) {
                case 'a':
                    System.out.println("Add to front (f) or end (e)?");
                    action = scan.next().charAt(0);
                    System.out.println("Insert value:");
                    item = scan.nextInt();
                    switch (action) {
                        case 'f':
                            queue.enqueueToFront(item);
                            break;
                        case 'e':
                            queue.enqueue(item);
                            break;
                    }
                    break;
                case 'r':
                    System.out.println("What position do you want the item to be removed from?");
                    position = scan.nextInt();
                    System.out.println("Removed value: " + queue.removeSpecified(position));
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
