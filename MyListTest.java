import de.tu_bs.ips.DataSource;
import de.tu_bs.ips.List;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit 5 test class
 *
 * @author Jane Doe 1234567 Group 42h
 * @author John Doe 1234567 Group 42h
 */
class MyListTest {
    static private List listFactory() {
        return new MyList();
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Iterator<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        List list = listFactory();
        assertTrue(list.isEmpty());
        list.insert(new TestEntry(dataSource.next()));
        assertFalse(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void length() {
        List list = listFactory();
        int i = 0;
        assertEquals(i, list.length());
        Iterator<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        while (dataSource.hasNext()) {
            list.insert(new TestEntry(dataSource.next()));
            i++;
            assertEquals(i, list.length());
        }
    }

    @org.junit.jupiter.api.Test
    void first() {
        Iterator<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        List list = listFactory();
        assertTrue(list.first() == null);
        TestEntry entry =  new TestEntry(dataSource.next());
        list.insert(entry);
        assertEquals(entry, list.first());
        list = listFactory();
        list.append(entry);
        assertEquals(entry, list.first());
        list = listFactory();
        list.sortedInsert(entry);
        assertEquals(entry, list.first());
    }

    @org.junit.jupiter.api.Test
    void insert() {
        List list = listFactory();
        assertTrue(list.first() == null);
        Iterable<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        LinkedList<TestEntry> javaList = new LinkedList<>();
        TestEntry entry;
        for (Integer[] integers : dataSource) {
            entry = new TestEntry(integers);
            list.insert(entry);
            javaList.addFirst(entry);
        }
        assertIterableEquals(javaList, list);
    }

    @org.junit.jupiter.api.Test
    void append() {
        List list = listFactory();
        assertTrue(list.first() == null);
        Iterable<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        LinkedList<TestEntry> javaList = new LinkedList<>();
        TestEntry entry;
        for (Integer[] integers : dataSource) {
            entry = new TestEntry(integers);
            list.append(entry);
            javaList.add(entry);
        }
        assertIterableEquals(javaList, list);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        List list = listFactory();
        LinkedList<TestEntry> javaList = new LinkedList<>();
        Iterable<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        TestEntry entry;
        for (Integer[] integers : dataSource) {
            entry = new TestEntry(integers);
            list.insert(entry);
            javaList.addFirst(entry);
        }

        while (!javaList.isEmpty())  {
            int index = (int) (javaList.size() * Math.random());
            entry = javaList.get(index);
            javaList.remove(entry);
            list.delete(entry);
            assertIterableEquals(javaList, list);
        }

    }

    @org.junit.jupiter.api.Test
    void iterator() {
        List list = listFactory();
        Iterator iterator = list.iterator();
        assertTrue(iterator != null);
        assertFalse(iterator.hasNext());

        TestEntry entry = new TestEntry(new Integer[]{1, 2, 3});

        list.append(entry);
        Iterator iterator2 = list.iterator();
        assertTrue(iterator2.hasNext());
        assertEquals(entry, iterator2.next());
        assertFalse(iterator2.hasNext());
        assertThrows(NoSuchElementException.class, iterator2::next);
    }

    @org.junit.jupiter.api.Test
    void sortedInsert() {
        List list = listFactory();
        assertTrue(list.first() == null);
        Iterable<Integer[]> dataSource = new DataSource(DataSource.Mode.A);
        LinkedList<TestEntry> javaList = new LinkedList<>();
        TestEntry entry;
        for (Integer[] integers : dataSource) {
            entry = new TestEntry(integers);
            list.sortedInsert(entry);
            javaList.add(entry);
        }
        Collections.sort(javaList);
        assertIterableEquals(javaList, list);
    }

    public static class TestEntry implements Comparable {

        private final Integer[] values;

        private TestEntry(final Integer[] values) {
            if (values == null || values.length != 3) {
                throw new IllegalArgumentException("wrong content");
            }
            this.values = values;
        }
        
        @Override
        public int compareTo(final Object o) {
            TestEntry e = (TestEntry) o;
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
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final TestEntry entry = (TestEntry) o;

            return Arrays.equals(values, entry.values);
        }

        @Override
        public String toString() {
            return "TestEntry" + Arrays.toString(values);
        }
    }
}