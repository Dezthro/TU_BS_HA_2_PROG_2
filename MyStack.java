import de.tu_bs.ips;

public class MyStack implements Stack {

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
    private Node peek;
    
    // Konstruktoren
    public MyStack() {
    
        peek = null;
    
    }
    
    public MyStack(Entry pEntry) {
    
        peek = new Node(pEntry);
    
    }
    
    public MyStack(MyStack pStack) {
    
        MyStack temp;
    
        while(!pStack.isEmpty()) {
        
            temp.push(pStack.pop());
        
        }
    
    }
    
    // Methoden
    public Entry peek() {
    
        return peek;
    
    }
    
    public void push(Entry pNew) {
    
        if(this.isEmpty()) {
        
            peek = new Node(pNew);
        
        } else {
        
            Node temp = this.element();
            while(temp.hasNext()) {
            
                temp = temp.getNext();
            
            }
            temp.setNext(new Node(pNew));
        
        }
    
    }
    
    public Entry pop() {
    
        if(this.peek() == null) {
        
            return null;
        
        } else {
        
            temp = this.element();
            first = temp.getNext();
            return temp.getEntry();
        
        }
    
    }

}
