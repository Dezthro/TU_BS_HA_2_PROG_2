import de.tu_bs.ips;

public class MyQueue implements Queue{

    public class Node {
  
        // Variabeln
        private Entry entry;
        private Node next;
    
        // Konstruktor
        public Node(Entry pEntry) {
    
            entry = pEntry;
            node = null;
    
        }
    
        public void setNext(Node pNext) {
        
            node = pNext;
    
        }
        
        // Methoden
        public Entry getEntry() {
        
            return entry;
        
        }
        
        public Node getNext() {
        
            return next;
        
        }
        
        public boolean hasNext() {
        
            return (next != null) ? true : false;
        
        }
        
        public String toString() {
        
            return entry.toString();
        
        }
  
    }
    
    // Variabeln
    private Node first;
    
    // Konstruktoren
    public MyQueue() {
    
        first = null;
    
    }
    
    public MyQueue(Entry pEntry) {
    
        first = new Node(pEntry);
    
    }
    
    public MyQueue(MyQueue pQueue) {
    
        while(!pQueue.isEmpty()) {
        
            this.add(pQueue.remove());
        
        }
    
    }
    
    // Methoden
    public Entry element() {
    
        return first;
    
    }
    
    public void add(Entry pNew) {
    
        if(this.isEmpty()) {
        
            first = new Node(pNew);
        
        } else {
        
            Node temp = this.element();
            while(temp.hasNext()) {
            
                temp = temp.getNext();
            
            }
            temp.setNext(new Node(pNew));
        
        }
    
    }
    
    public Entry remove() {
    
        if(this.element() == null) {
        
            return null;
        
        } else {
        
            temp = this.element();
            first = temp.getNext();
            return temp.getEntry();
        
        }
    
    }

}
