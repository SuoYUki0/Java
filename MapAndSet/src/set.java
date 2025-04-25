import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class set {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        boolean isIn = s.add("apple");
        s.add("orange");
        s.add("peach");
        s.add("banana");
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.contains("apple"));
        System.out.println(s.contains("watermelen"));
        s.remove("apple");
        System.out.println(s);
        s.remove("watermelen");
        System.out.println(s);
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

    }
}
