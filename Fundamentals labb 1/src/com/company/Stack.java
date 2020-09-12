package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;

//A linked list stack
public class Stack<Item> implements Iterable<Item>{

    private Node<Item> topOfStack;
    private int size;

    // A class defining a node
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    /**
     * Stack constructor intializing the values
     */
    public Stack(){
        topOfStack = null;
        size = 0;
    }

    /**
     * Checks if the stack is empty
     * @return true if the top the the stack is null
     */
    public boolean isEmpty(){
        return topOfStack == null;
    }

    /**
     * Checks the size of the stack
     * @return the size of the stack
     */
    public int size(){
        return size;
    }

    /**
     * Adds an item to the top of the stack
     * @param item the item to be added
     */
    public void push(Item item){
        Node<Item> oldfirst = topOfStack;
        topOfStack = new Node<Item>();
        topOfStack.item = item;
        topOfStack.next = oldfirst;
        size++;
    }

    /**
     * Removes an item from the top of the stack
     * @return the removed item
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = topOfStack.item;
        topOfStack = topOfStack.next;
        size--;
        return item;
    }

    /**
     * Peeks at the item on the top of the stack
     * @return the item on the top of the stack
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return topOfStack.item;
    }

    /**
     * Checks if two parentheses are oposites. ( and ), [ and ], { and }
     * @param item1 the first parenthesis
     * @param item2 the second parenthesis
     * @return true if the parentheses are opposites
     */
    public boolean areOpposites(Item item1, Item item2){
        if((Character) item1 == '(' && (Character) item2 == ')' || (Character) item1 == '[' && (Character) item2 == ']' || (Character) item1 == '{' && (Character) item2 == '}'){
            return true;
        }
        return false;
    }

    /**
     * Creates a StringBuilder containing the data presented as requested in the assignment description
     * @return a string containing all the values in the stack in the right format
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item item : this) {
            s.append("[");
            s.append(item);
            s.append("], ");
        }
        if(s.lastIndexOf(",") > 0)  {  s.deleteCharAt(s.lastIndexOf(",")); }
        return s.toString();
    }

    /**
     * Iterator starting at the first value
     * @return a linked list iterator starting at "topOfStack" value
     */
    public Iterator<Item> iterator(){
        return new LinkedIterator(topOfStack);
    }

    //LinkedIterator class implementing the functions needed for an iterator
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        /**
         * The constructor
         * @param first the first node
         */
        public LinkedIterator (Node<Item> first) {
            current = first;
        }

        /**
         * Checks is the current node has a following node
         * @return true if the current node is not null
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Supposed to remove a value, not supported by default
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Makes the current node equal to the next, therefore iterating through the queue
         * @return current item
         */
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
