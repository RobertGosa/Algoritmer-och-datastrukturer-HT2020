import java.util.NoSuchElementException;

//The Binary Search Symbol Table following the example in the course book
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2; //starting capacity
    private Key[] keys;
    private Value[] vals;
    private int n = 0; //number of elements

    /**
     * Constructor
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    } //constructor

    /**
     * Constructor
     * @param capacity size of the symbol table
     */
    public BinarySearchST(int capacity) { //constructor
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    /**
     * Resize the symbol table
     * @param capacity the new size
     */
    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity]; //make new arrays
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) { //put all the values in the arrays
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    /**
     * Returns the size of the symbol table
     * @return the size
     */
    public int size() {
        return n;
    }

    /**
     * Checks if the symbol table is empty
     * @return true is the symbol table is empty;
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Checks if the key is already in the ST
     *
     * @param  key the key to look for
     * @return true is the key is found in the array
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Find the value that the given key has
     * @param  key the key to look for
     * @return the value of the key
     */
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key); //find the position of the key
        if (i < n && keys[i].compareTo(key) == 0) return vals[i]; //if position is in the array and the key value matches the given key, return the value of the key
        return null; //if the key is not in the array, return null
    }

    /**
     * Find the position of the key
     * @param  key the key to look for
     * @return the position of the key
     */
    public int rank(Key key) {
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; //find the middle
            int cmp = key.compareTo(keys[mid]); //compare to the middle
            if      (cmp < 0) hi = mid - 1; //if less than the middle, look at the first half
            else if (cmp > 0) lo = mid + 1; //if higher than the middle, look at the second half
            else return mid;  //else, return the position
        }
        return lo;
    }



    /**
     * Puts the key and value in the ST
     * @param  key the key
     * @param  val the value
     */
    public void put(Key key, Value val)  {

        int i = rank(key); //find the position the key should be on

        if (i < n && keys[i].compareTo(key) == 0) { //if the key is already in the ST, update the value
            vals[i] = val;
            return;
        }

        if (n == keys.length) resize(2*keys.length); //if the keys are not equal, then we need to insert something new. If no more space, double the array size

        for (int j = n; j > i; j--)  { //move all the keys up one position
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; //insert the key and value
        vals[i] = val;
        n++;
    }

    /**
     * Returns all keys in this symbol table
     * @return all the keys
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>(); //make a queue to return
        for (int i = 0; i < n; i++) //for each key
            queue.enqueue(keys[i]); //add to queue
        return queue;
    }

    /**
     * Returns all values in this symbol table
     * @return all the values
     */
    public Iterable<Value> values() {
        Queue<Value> queue = new Queue<Value>(); //make a queue to return
        for (int i = 0; i < n; i++) //for each key
            queue.enqueue(vals[i]); //add to queue
        return queue;
    }
}