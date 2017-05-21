import de.tu_bs.ips;

public class MyStack implements Stack {

    public class Node {
  
        // Variabeln
        private Entry<T> entry;
        private Node next;
    
        // Konstruktor
        public Node(Entry<T> pEntry) {
    
            entry = pEntry;
            next = null;
    
        }
        
        public Node(Entry<T> pEntry, Node pNext) {
        
            entry = pEntry;
            next = pNext;
        
        }
    
        public void setNext(Node pNext) {
        
            node = pNext;
    
        }
        
        // Methoden
        public Entry<T> getEntry() {
        
            return entry;
        
        }
        
        public Node getNext() {
        
            return next;
        
        }
        
        public boolean hasNext() {
        
            return (next != null) ? true : false;
            
        }
  
    }
    
    // Variabeln
    private Node peek;
    
    // Konstruktoren
    public MyStack() {
    
        peek = null;
    
    }
    
    public MyStack(Entry<T> pEntry) {
    
        peek = new Node(pEntry);
    
    }
    
    public MyStack(MyStack pStack) {
    
        MyStack temp;
    
        while(!pStack.isEmpty()) {
        
            temp.push(pStack.pop());
        
        }
        
        while(!temp.isEmpty()) {
        
            this.push(temp.pop());
        
        }
    
    }
    
    // Methoden
    public boolean isEmpty() {
    
        return (this.peek() != null) ? true : false;
    
    }
    
    public Node peek() {
    
        return peek;
    
    }
    
    public void push(Entry<T> pNew) {
    
        if(this.isEmpty()) {
        
            peek = new Node(pNew);
        
        } else {
        
            peek = new Node(pNew, this.peek());
        
        }
    
    }
    
    public Entry pop() {
    
        if(this.isEmpty()) {
        
            return null;
        
        } else {
        
            Node temp = this.peek();
            peek = temp.getNext();
            return temp.getEntry();
        
        }
    
    }

}
