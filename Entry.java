package advancedList;

import java.util.Arrays;

/**
 * Container class for the integer arrays
 *
 * @author Jane Doe 1234567 Group 42h
 * @author John Doe 1234567 Group 42h
 */
public class Entry<T> implements Comparable<T> {

    /**
     * the integer array with a length of 3
     */
    private final Integer[] values;

    /**
     * creates a new entry object with the given array
     * @param values the integer array
     */
    public Entry(final Integer[] values) {
        if (values == null || values.length != 3) {
            throw new IllegalArgumentException("wrong content");
        }
        this.values = values;
    }

    @Override
    public int compareTo(T o) {
        Entry<T> e = (Entry<T>) o;
        if (Integer.compare(values[0], e.values[0]) == 0) {
            if (Integer.compare(values[1], e.values[1]) == 0) {
                return Integer.compare(values[2], e.values[2]);
            } else {
                return Integer.compare(values[1], e.values[1]);
            }
        }
        return Integer.compare(values[0], e.values[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Entry<T> entry = (Entry<T>) o;
        return Arrays.equals(values, entry.values);
    }
    
    @Override
    public String toString() {
        return "Entry" + Arrays.toString(values);
    }

}
