import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    public Deque(){
        first=null;
        last=null;
        n=0;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }

    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return n;
    }
    public void addFirst(Item item){

        Node newNode = new Node();
        newNode.item = item;
        first.previous = newNode;
        newNode.next = first;
        newNode.previous = null;
        first = newNode;

    }
    public void addLast(Item item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.previous = last;
        last.next = newNode;
        newNode.next = null;
        last = newNode;
    }
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        first.previous = null;
        n--;
        if (isEmpty()) first = null;   // to avoid loitering
        return item;
    }
    public Item removeLast(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.item;
        last = last.previous;
        last.next = null;
        n--;
        if(isEmpty()) last = null;
        return item;
    }
    public Iterator<Item> iterator(){
        return new LinkedIterator(first);

    }
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
