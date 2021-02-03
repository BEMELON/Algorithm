import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next, prev;
    }

    private Node head, last;
    private int size = 0;

    // construct an empty deque
    public Deque() {
        head = new Node();
        last = new Node();
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addhead(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node current = new Node();
        current.item = item;

        if (isEmpty()) {
            head = current;
            last = current;
        } else {
            head.prev = current;
            current.next = head;
            head = current;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node current = new Node();
        current.item = item;

        if (isEmpty()) {
            head = current;
            last = current;
        } else {
            last.next = current;
            current.prev = last;
            last = current;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removehead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item data = head.item;
        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item data = last.item;
        last = last.prev;
        last.next = null;
        size--;
        return data;
    }

    private class ItemIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item data = current.item;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // return an iterator over items on order from front to back
    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        
    }
}
