// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class LinHashTable<E> extends ReHashTable<E> {
    public LinHashTable(int capacity) {
        super(capacity);
    }

    // Implements a basic hash function.
    protected int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % capacity;
    }

    // Linear rehashing to implement linear probing behavior.
    protected int rehash(int previousHash) {
        return (previousHash + 1) % this.capacity;
    }
}