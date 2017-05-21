import de.tu_bs.ips;

/**
* Klassenbeschreibung
*
*@author Marius Bonke 4839983 Gruppe 3b
*@author Lucas Schröder 4809832 Gruppe 3b
*/
public class TestMain extends Test{

    public static void main(String[] args) {
    
        // Vorher
        Iterable<Integer> integers = new IntegerDataSource();
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        System.out.println("--------------------");

        Iterable<Integer[]> integerArrays = new DataSource<Integer[]>(new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        
        for (Integer[] integer : integerArrays) {
            System.out.println(Arrays.toString(integer));
        }

        System.out.println("--------------------");

        Iterable<String> strings = new StringDataSource();
        for (String string : strings) {
            System.out.println(string);
        }
        
        // Nachher
        MyQueue queue = new MyQueue();
        MyStack stack = new MyStack();
        MyList<String> stringList = new MyList<String>();
        MyList<Integer[]> intList = new MyList<Integer[]>();
        Iterable<String> string = new StringDataSource();
        Iterable<Integer> integer = new IntegerDataSource();
        
        System.out.println("Liste   Queue   Stack");
        for (String string : string) {
        
            stringList.insert(new Entry<String>(string));
            queue.add(new Entry<String>(string));
            queue.push(new Entry<String>(string));
            System.out.println("+" + string + "    +" + string + "    +" + string);
            
        }
        
        while(!stack.isEmpty()) {
        
            System.out.print("-" + stringList.first().toString());
            stringList.delete();
            System.out.println("   -" + queue.remove());
            System.out.println("   -" + stack.pop());
        
        }
        
        System.out.println("Liste   Queue   Stack");
        for (Integer[] integer : integer) {
        
            stringList.insert(new Entry<Integer[]>(integer));
            queue.add(new Entry<Integer[]>(integer));
            queue.push(new Entry<Integer[]>(integer));
            System.out.println("+" + integer + "    +" + integer + "    +" + integer);
            
        }
        
        while(!stack.isEmpty()) {
        
            System.out.print("-" + stringList.first().toString());
            stringList.delete();
            System.out.println("   -" + queue.remove());
            System.out.println("   -" + stack.pop());
        
        }
    
    }

}
