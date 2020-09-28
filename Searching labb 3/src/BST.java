import java.util.NoSuchElementException;

//The BST following the example in the course book
public class BST<Key extends Comparable<Key>, Value> {
    private Node head;             //head node

    private class Node {
        private Key key;           //the key
        private Value val;         //the value
        private Node left, right;  //references to lower and higher value nodes
        private int size;          //number of nodes under this node

        //Constructor
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Constructor
     */
    public BST() {
    }

    /**
     * Get the value of a key
     * @param key the given key
     * @return the value of the key
     */
    public Value get(Key key) {
        return get(head, key);
    }

    /**
     * Get the value of a key
     * @param key the given key
     * @param x the starting node
     * @return the value of the key
     */
    private Value get(Node x, Key key) {
        if (x == null) return null; //if x is null, the key does not exist
        int cmp = key.compareTo(x.key); //compare the key to x key
        if (cmp < 0) return get(x.left, key); //if lower, look to the left
        else if (cmp > 0) return get(x.right, key); //if higher, look to the right
        else return x.val; //if found, return the value
    }

    /**
     * Puts the key and value in the tree
     * @param key the key
     * @param val the value
     */
    public void put(Key key, Value val) {
        head = put(head, key, val);
    }

    /**
     * Puts the key and value in the tree
     * @param key the key
     * @param val the value
     * @param x the starting node
     */
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1); //if the node does not exist, create it
        int cmp = key.compareTo(x.key); //compare the given key to the value of the node
        if (cmp < 0) x.left = put(x.left, key, val); //if it's lower go to the left
        else if (cmp > 0) x.right = put(x.right, key, val); //if it's higher, go to the right
        else x.val = val; //otherwise, update value
        x.size = 1 + size(x.left) + size(x.right); //update the size
        return x; //return
    }

    /**
     * Returns the size of a node
     * @param x the node
     * @return the size
     */
    private int size(Node x) {
        if (x == null) return 0; //if the node does not exist
        else return x.size;
    }

    /**
     * Returns the size of the whole tree
     * @return size of head
     */
    public int size(){
        return size(head);
    }

    /**
     * Checks if a key is in the tree
     * @param key the key to look for
     * @return true if the key is in the tree, false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Return all the keys
     * @return
     */
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(head, queue, lo, hi);
        return queue; //the queue to return
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { //return the keys in in-fix order. Check left, if nothing there print the value, then check right
        if (x == null) return;
        int cmplo = lo.compareTo(x.key); //compare the key to the lowest value
        int cmphi = hi.compareTo(x.key); //compare the key to the highest value
        if (cmplo < 0) keys(x.left, queue, lo, hi); //if the lowest value is lower than the x value, go left
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); //if the value is higher than or equal to the lowest one and smaller than or equal to the highest one, enqueue it
        if (cmphi > 0) keys(x.right, queue, lo, hi); //if the highest value is higher than the key value, go right
    }

    /**
     * Checks is the tree is empty
     * @param
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the smallest value node
     * @return the smallest value node
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(head).key;
    }

    /**
     * Returns the smallest value node starting with x
     * @param x the node to search from
     * @return x if there are no smaller nodes
     */
    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    /**
     * Returns the highest value node
     * @return the highest value node
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(head).key;
    }

    /**
     * Returns the highest value node starting with x
     * @param x the node to search from
     * @return x if there are no higher value nodes
     */
    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    /**
     * Find the position of a key
     * @param  key the key
     * @return the position of the key
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, head);
    }

    /**
     * Find the position of a key
     * @param  key the key
     * @param x the node to start counting from
     * @return the position of the key
     */
    private int rank(Key key, Node x) {
        if (x == null) return 0; //if the node does not exist, return 0
        int cmp = key.compareTo(x.key); //compare the node value with the key value
        if      (cmp < 0) return rank(key, x.left); //if less, go to the left
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); //if more, go to the right
        else              return size(x.left);  //else return the number of nodes lower
    }
}