//The Linear Probing Hash Symbol Table following the example in the course book
public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           //number of elements
    private int m;           //maximum size
    private Key[] keys;      //the keys
    private Value[] vals;    //the values


    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key};
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity); //make a new bigger array
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) { //for every value that was in the old array
                temp.put(keys[i], vals[i]); //copy the values
            }
        }
        keys = temp.keys; //change the references back
        vals = temp.vals;
        m = temp.m;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) { //TODO comment this
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (n >= m / 2) resize(2 * m); //if the array is half full, double the size. This makes the program work faster because it lowers the chance of a worst case scenario where the only available place is one position behind the starting point and it takes N comparisons to find it.

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) { //start at the hash value and look there first, then at all the values after it until we find the right key
            if (keys[i].equals(key)) { //if right key is found
                vals[i] = val; //update value
                return;
            }
        }
        keys[i] = key; //if key was not found put it on the right place
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     *
     * @param key the key
     * @return the value associated with {@code key};
     * {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) //look at the hash position for the key, as long as the values are not null and if the values are not the same keep looking at the next position until you find the key
            if (keys[i].equals(key)) //if the key is found
                return vals[i]; //return its value
        return null; //else return null
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>(); //make a new queue
        for (int i = 0; i < m; i++) //for every value
            if (keys[i] != null) queue.enqueue(keys[i]); //if the key is not null, enqueue it
        return queue; //return the queue
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Value> values() {
        Queue<Value> queue = new Queue<>(); //make a new queue
        for (int i = 0; i < m; i++) //for every value
            if (vals[i] != null) queue.enqueue(vals[i]); //if the key is not null, enqueue it
        return queue; //return the queue
    }
}