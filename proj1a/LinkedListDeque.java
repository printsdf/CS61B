public class LinkedListDeque<T> {
    public class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }

        private Node(Node p, Node n) {
            prev = p;
            next = n;
        }

    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        size++;
        Node p = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    /**
     * adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        size++;
        Node p = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    /**
     * returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**
     * removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.next;
        T i = p.item;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size--;
        return i;
    }

    /**
     * removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.prev;
        T i = p.item;
        p.prev.next = sentinel;
        sentinel.prev = p.prev;
        size--;
        return  i;
    }

    /**
     * gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /**
     * to help getRecursive
     */
    private T getRecursiveHelp(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelp(index - 1, p.next);
    }

    /**
     * same as get, but uses recursion
     */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelp(index, sentinel.next);
    }
}
