package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.*;

//A double linked list circular Queue
public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    /**
     * Node class defining a node
     */
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    /**
     * Queue constructor
     */
    public Queue(){
        first = new Node<Item>();
        last =  new Node<Item>();
        first.prev = last;
        last.next = first;
        size = 0;
    }

    /**
     * Checks if the queue is empty
     * @return true if the size is 0
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Adds a node to the back of the Queue
     * @param item the item to be added
     */
    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = first;
        last.prev = oldlast;
        if (isEmpty()) {
            last.prev = first;
            first = last;
        }
        else{
            oldlast.next = last;
        }
        size++;
        System.out.println(this.toString());
    }

    /**
     * Adds a node to the beginning of the queue
     * @param item the item to be added
     */
    public void enqueueToFront(Item item){
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        oldfirst.prev = first;
        first.prev = last;
        if (isEmpty()) {
            last = first;
            first.next = first;
        }
        else{
            last.next = first;
            first.next = oldfirst;
        }
        size++;
        System.out.println(this.toString());
    }

    /**
     * Removes a node from the front of the queue
     * @return the item that was removed
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("No element to dequeue");
        Item item = first.item;
        first = first.next;
        first.prev = last;
        size--;
        if (isEmpty()) {
            last.next = null;
            System.out.println("Front -Empty- End");
        } else {
            System.out.println(this.toString());
        }
        return item;
    }

    /**
     * Removes a node from the back of the queue
     * @return the item that was removed
     */
    public Item dequeueFromEnd(){
        if (isEmpty()) throw new NoSuchElementException("No element to dequeue");
        Item item = last.item;
        last = last.prev;
        last.next = null;
        size--;
        if (isEmpty()) {
            last.next = null;
            System.out.println("Front -Empty- End");
        } else {
            System.out.println(this.toString());
        }
        return item;
    }

    /**
     * Removes a node on a specified position
     * @param position the position of the node to be removed
     * @return the removed node
     */
    public Item removeSpecified(int position){
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Node<Item> currentNode = first;
        Node<Item> removedNode = null;
        if (position == 1) {
            removedNode = first;
            dequeue();
        } else {
            for (int i = 2; i < position; i++) {
                currentNode = currentNode.next;
            }
            removedNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            size--;
        }
        if(position != 1) {
            System.out.println(this.toString());
        }
        return removedNode.item;
    }

    /**
     * Adds nodes to the queue and makes sure they are in ascending order by the value of the item in them
     * @param item the item to be added
     */
    public void enqueueInOrder(Item item) {
        Node<Item> currentNode = first;
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        if (this.isEmpty()) { // if the queue is empty, enqueue as usual
            enqueue(item);
            System.out.println(first.item);
        } else if ((Integer) item <= (Integer) currentNode.item) { // if the item has a lower value than the first one, add to the front
            enqueueToFront(item);
        } else {
            while ((Integer) item > (Integer) currentNode.item) { // if none of the above is true, iterate through the queue untill we reach the end
                if (currentNode.next.item != null && currentNode.next != first) {
                    currentNode = currentNode.next;
                } else {
                    break;
                }
            }
            if (currentNode == last) { // after iterating, if we reached the end and the item value is higher than the last value, enqueue it
                if ((Integer) item > (Integer) last.item) {
                    enqueue(item);
                } else { // else, add it before the current node
                    currentNode.prev.next = newNode;
                    newNode.next = currentNode;
                    newNode.prev = currentNode.prev;
                    currentNode.prev = newNode;
                    size++;
                    System.out.println(this.toString());
                }
            } else { // if the value it not last
                currentNode.prev.next = newNode;
                newNode.next = currentNode;
                newNode.prev = currentNode.prev;
                currentNode.prev = newNode;
                size++;
                System.out.println(this.toString());
            }
        }
    }

    /**
     * Creates a StringBuilder containing the data presented as requested in the assignment description
     * @return a string containing all the values in the queue in the right format
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Front ");
        for (Item item : this){
            s.append("[");
            s.append(item);
            s.append("], ");
        }
        s.append("End");
        if(s.lastIndexOf(",") > 0)  {  s.deleteCharAt(s.lastIndexOf(",")); }
        return s.toString();
    }

    /**
     * Iterator starting at the first value
     * @return a linked list iterator starting at "first" value
     */
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    //LinkedIterator class implementing the functions needed for an iterator
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;
        private int counter = 0;

        /**
         * The constructor
         * @param first the first node
         */
        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        /**
         * Checks is the current node has a following node
         * @return true if counter is less than the size of the queue
         */
        public boolean hasNext()  {
            return counter < size;
        }

        /**
         * Supposed to remove a value, not supported by default
         */
        public void remove()      { throw new UnsupportedOperationException();  }

        /**
         * Iterates the counter and makes the current node equal to the next, therefore iterating through the queue
         * @return current item
         */
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            counter++;
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
