package advancedList;

public class MySortedList<E> extends MyList<E>{
	
	@Override 
	public append(E e) {
		return new UnsupportedOperationException();
	}
	
	public void sortedInsert(E e) {
        MyList<E> cur = this;
        while (!cur.isEmpty() && ((Comparable<Entry<E>>) e).compareTo((Entry<E>) cur.first()) > 0) {
            cur = cur.next;
        }
        cur.insert(e);
    }
}
