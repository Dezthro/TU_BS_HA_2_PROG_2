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
public class MyList implements List {
    /**
     * next pointer to the next list element
     */
    private MyList next;
    /**
     * previous pointer to the previous list element
     */
    private MyList prev;
    /**
     * the item / element
     */
    private Comparable entry;

    /**
     * creates a new List
     */
    public MyList() {
        next = this;
        prev = this;
    }

    @Override
    public boolean isEmpty() {
        return first() == null;
    }

    @Override
    public int length() {
        MyList cur = this;
        int l = 0;
        while (!cur.isEmpty()) {
            cur = cur.next;
            l++;
        }
        return l;
    }

    @Override
    public Comparable first() {
        return next.entry;
    }

    @Override
    public void insert(final Comparable e) {
        MyList newEntry = new MyList();
        newEntry.entry = e;
        newEntry.prev = this;
        newEntry.next = next;
        next.prev = newEntry;
        next = newEntry;
    }

    @Override
    public void append(final Comparable e) {
        prev.insert(e);
    }

    @Override
    public void delete(final Comparable e) {
        MyList cur = this;
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
            private MyList current = MyList.this;

            @Override
            public boolean hasNext() {
                return !current.isEmpty();
            }

            @Override
            public Comparable next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("");
                }
                Comparable e = current.first();
                current = current.next;
                return e;
            }
        };
    }
    
    @Override
    public void sortedInsert(final Comparable e) {
        MyList cur = this;
        while (!cur.isEmpty() && e.compareTo(cur.first()) > 0) {
            cur = cur.next;
        }
        cur.insert(e);
    }
}
