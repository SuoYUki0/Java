import java.util.Arrays;

public class TestHeap {
   private int[] elem;
   private int usedSize;
   public TestHeap(){
       this.elem=new int[10];
   }
    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }
    public void createHeap(){
       for(int parent=(usedSize-1-1)/2;parent>=0;parent--){
           shiftDown(parent,usedSize);
       }
    }

    private void shiftDown(int parent, int usedSize) {
       int child=(2*parent)+1;
       while (child<usedSize){
           if(child+1<usedSize&&elem[child]<elem[child+1]){
               child++;
           }
           if(elem[child]>elem[parent]){
               swap(child,parent);
               parent=child;
               child=(2*parent)+1;
           }
           else{
               break;
           }
       }
    }

    private void swap(int child, int parent) {
       int tmp=elem[child];
       elem[child]=elem[parent];
       elem[parent]=tmp;
    }
    public void offer(int val){
       if(isFull()){
           this.elem= Arrays.copyOf(elem,2*elem.length);
       }
       this.elem[usedSize]=val;
       shiftUp(usedSize);
       usedSize++;
    }
    private void shiftUp(int child){
       int parent=(child-1)/2;
       while (child>0){
           if(elem[child]>elem[parent]){
               swap(child,parent);
               child=parent;
               parent=(child-1)/2;
           }
           else {
               break;
           }
       }
    }
    public boolean isFull(){
       return usedSize==elem.length;
    }
    public int poll(){
       int tmp=elem[0];
       swap(0,usedSize-1);
       usedSize--;
       shiftDown(0,usedSize);
       return tmp;
    }
    public void heapSort(){
       int end=usedSize-1;
       while (end>0){
           swap(0,end);
           shiftDown(0,end);
           end--;
       }
    }

}