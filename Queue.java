package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.*;

public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
        private boolean iterated = false;
    }

    public Queue(){
        first = new Node<Item>();
        last =  new Node<Item>();
        first.prev = last;
        last.next = first;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Item peek(){
        return first.item;
    }

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
            first.next = oldfirst;
        }
        size++;
        System.out.println(this.toString());
    }

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

    public Item removeSpecified(int position){
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Node<Item> currentNode = first;
        Node<Item> removedNode = null;
        if (position == 1) {
            dequeue();
        } else {
            for (int i = 2; i < position; i++) {
                currentNode = currentNode.next;
            }
            removedNode = currentNode.next;
            currentNode.next = currentNode.next.next;
        }
        size--;
        System.out.println(this.toString());
        return removedNode.item;
    }

    public void enqueueInOrder(Item item){
        Node<Item> currentNode = first;
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        int counter = 0;
        if(this.isEmpty()){
            enqueue(item);
            System.out.println(first.item);
        } else if((Integer) item < (Integer) currentNode.item)  {
            enqueueToFront(item);
        } else {
            while((Integer) item > (Integer) currentNode.item) {
                if (counter == size - 1) {
                    enqueue(item);
                }
                currentNode = currentNode.next;
                counter++;
            }
            currentNode.prev.next = newNode;
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev = newNode;
        }
    }

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

    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;
        private int counter = 0;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }


        public boolean hasNext()  {
            return counter < size;
        }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            counter++;
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
