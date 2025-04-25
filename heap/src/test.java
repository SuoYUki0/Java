import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collector;

class IntCmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
class Student{
    public String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
public class test {
    public static int[] maxLestK(int[] array,int k){
        int[] ret=new int[k];
        if(array==null||k<=0){
            return ret;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            priorityQueue.offer(array[i]);
        }
        for(int i=k;i< array.length;i++){
            int top=priorityQueue.peek();
            if(array[i]>top){
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        for(int i=0;i<k;i++){
            ret[i]= priorityQueue.poll();
        }
        return ret;
    }
    public int[] smallestK(int[] array,int k){
        int[] ret=new int[k];
        if(array==null||k<=0){
            return ret;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new IntCmp());
        for(int i=0;i<k;i++){
            priorityQueue.offer(array[i]);
        }
        for (int i=k;i< array.length;i++){
            int top= priorityQueue.peek();
            if(array[i]<top){
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        for(int i=0;i<k;i++){
            ret[i]=priorityQueue.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "zhangsan";
        Student student2 = new Student();
        student2.name =  "zhangsan";

        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

    }
    public static void main44(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initHeap(array);

        testHeap.createHeap();

        testHeap.heapSort();

        System.out.println("====");
    }
    public static void main5(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initHeap(array);

        testHeap.createHeap();

        System.out.println("===插入元素==");
        //testHeap.offer(80);
        System.out.println("===删除===");
        int val = testHeap.poll();
        System.out.println(val);
        System.out.println("====");
    }
}
