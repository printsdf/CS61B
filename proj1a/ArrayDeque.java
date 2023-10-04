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

    private void resize() {
        if (size == items.length) {
            expand();
        }
        if (size < (items.length) * 0.25 && items.length > 8) {
            reduce();
        }
    }

    /**
     * get the last index.
     */
    private int minusOne(int index) {
        return Math.floorMod(index - 1, items.length);
    }

    /**
     * get the next index.
     */
    private int plusOne(int index) {
        return Math.floorMod(index + 1, items.length);
    }

    /**
     * adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;
        minusOne(nextFirst);
    }

    /**
     * adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        items[nextLast] = item;
        size++;
        plusOne(nextLast);
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
        if (isEmpty()) {
            return null;
        }
        plusOne(nextFirst);
        T item = items[nextFirst];
        size--;
        return item;
    }

    /**
     * removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        minusOne(nextLast);
        T item = items[nextLast];
        size--;
        return item;
    }

    /**
     * gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            return null;
        }
        index = Math.floorMod(plusOne(nextFirst) + index, items.length);
        return items[index];
    }

    private void resizeHelper(int capacity) {
        T[] a = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i)) {
            items[nextLast] = a[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = a[end];
        nextLast = plusOne(nextLast);
    }

    private void reduce() {
        resizeHelper(items.length / 2);
    }

    private void expand() {
        resizeHelper(items.length * 2);
    }
}
