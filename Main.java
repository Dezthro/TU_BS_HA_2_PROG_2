import de.tu_bs.ips.DataSource;
import de.tu_bs.ips.List;

/**
 * Simple test class for MyList
 *
 * @author Jane Doe 1234567 Group 42h
 * @author John Doe 1234567 Group 42h
 */
public class Main {
    /**
     * the main method
     * @param ignored ignored
     */
    public static void main(String[] ignored) {
        // create a new data source
        DataSource dataSource = new DataSource(DataSource.Mode.A);
        List list = new MyList();

        System.out.println(dataSource.size());

        // sorted insert every element from the data source in the list
        for (Integer[] integers : dataSource) {
            list.sortedInsert(new Entry(integers));
        }
        System.out.println("Fill list");
        System.out.println("list.length() = " + list.length());
        System.out.println("Print list");
        // print all elements from the list with the iterator
        for (Object entry : list) {
            System.out.println(entry);
        }

        dataSource = new DataSource(DataSource.Mode.A);
        // delete all elements from the list
        for (Integer[] integers : dataSource) {
            list.delete(new Entry(integers));
        }
        System.out.println("Clear list");
        System.out.println("list.length() = " + list.length());
    }
}
