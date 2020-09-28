//The Separate Chaining Hash Symbol Table following the example in the course book
public class SeparateChainingHashST<Key, Value> {

    private int n;       //the number of values in the ST
    private int m;       //the size of the ST
    private Node[] st;   //an array of nodes pointing to lists

    //node class
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        //constructor
        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    //constructor
    public SeparateChainingHashST() {
        this(9945);
    }

    //constructor
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = new Node[m];
    }


    //change the hash value so it is between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    //return the size
    public int size() {
        return n;
    }

    //check is the ST is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    //check if the ST contains a key
    public boolean contains(Key key) {
        return get(key) != null;
    }

    //get the value of the key
    public Value get(Key key) {
        int i = hash(key); //find the hash position
        for (Node x = st[i]; x != null; x = x.next) { //starting with the first node in the list on the "i" position, iterate through the list
            if (key.equals(x.key)) return (Value) x.val; //if the key matches, return its value
        }
        return null; //if the key does not exists, return null
    }

    //put the key and value into the ST
    public void put(Key key, Value val) {
        int i = hash(key); //find the has position
        for (Node x = st[i]; x != null; x = x.next) { //search through the list starting at the node on st[i]
            if (key.equals(x.key)) { //if the key in the list matches the key we are trying to put in the ST
                x.val = val; //update the value
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]); //if the key was not found in the ST, make a new nod at the hash position with the key and value
    }

    //return all the keys
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>(); //make a new queue to return later
        for (int i = 0; i < m; i++) { //for every value from 0 to size
            for (Node x = st[i]; x != null; x = x.next) { //for each node following the one on the "i" position
                queue.enqueue((Key) x.key); //enqueue the key value to the list
            }
        }
        return queue; //when done return the list
    }

    //return the size of a given list
    public int listSize(int i ){
        int size = 0;
        for (Node x = st[i]; x != null; x = x.next) { //for every node on the "i" position
            size++; //increment the size
        }
        return size; //when done, return the size
    }
}