public class ArrayDeque<T> {

    private T[] items;
    private int size;

    private int nextFirst;
    
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = items[nextFirst == items.length - 1 ? 0 : nextFirst + 1];
            nextFirst++;
        }
        size = capacity;
        nextFirst = size - 1;
        nextLast = items.length - 1;
        items = a;
    }
    
    /**
     * adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size++;
        nextFirst = nextFirst == 0 ? items.length - 1 : nextFirst - 1;
    }

    /**
     * adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size++;
        nextLast = nextLast == items.length - 1 ? 0 : nextLast + 1;
    }

    /**
     * returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
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
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /**
     * removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        if (size >= 16 && (double) size / items.length < 0.25) {
            resize(size / 2);
        }
        nextFirst = nextFirst == items.length - 1 ? 0 : nextFirst + 1;
        T item = items[nextFirst];
        items[nextFirst] = null;
        return item;
    }

    /**
     * removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        if (size >= 16 && (double) size / items.length < 0.25) {
            resize(size / 2);
        }
        nextLast = nextLast == 0 ? items.length - 1 : nextLast - 1;
        T item = items[nextLast];
        items[nextLast] = null;
        return item;
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
        return items[(nextFirst + index + 1) % items.length];
    }
}
