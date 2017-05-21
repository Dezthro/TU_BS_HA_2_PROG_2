package advancedList;

import de.tu_bs.ips.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class for a double-ended circular list
 * the head.entry element is always null to
 *
 * @author Jane Doe 1234567 Group 42h
 * @author John Doe 1234567 Group 42h
 */
public class MyList<E> implements List<E> {
    /**
     * next pointer to the next list element
     */
    private MyList<E> next;
    /**
     * previous pointer to the previous list element
     */
    private MyList<E> prev;
    /**
     * the item / element
     */
    private MyList<E> entry;

    /**
     * creates a new List
     */
    public MyList () {
        next = this;
        prev = this;
    }

    @Override
    public boolean isEmpty() {
        return first() == null;
    }

    @Override
    public int length() {
        MyList<E> cur = this;
        int l = 0;
        while (!cur.isEmpty()) {
            cur = cur.next;
            l++;
        }
        return l;
    }

    @Override
    public MyList<E> first() {
        return next.entry;
    }

    @Override
    public void insert(final E e) {
        MyList<E> newEntry = new MyList<E>();
        newEntry.entry = e;
        newEntry.prev = this;
        newEntry.next = next;
        next.prev = newEntry;
        next = newEntry;
    }

    @Override
    public void append(E e) {
        prev.insert(e);
    }

    @Override
    public void delete(E e) {
        MyList<E> cur = this;
        while (!cur.isEmpty() && !e.equals(cur.first())) {
            cur = cur.next;
        }
        if (isEmpty()) {
            return;
        }
        cur.next = cur.next.next;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private MyList<E> current = MyList<E>.this;

            @Override
            public boolean hasNext() {
                return !current.isEmpty();
            }

            @Override
            public Comparable<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("");
                }
                Comparable<T> e = current.first();
                current = current.next;
                return e;
            }
        };
    }
    
    

}
