import java.sql.SQLOutput;
import java.util.Arrays;

public class MyArrayList {
    private int[] elem;//用来存放数据
    private int usedSize;//代表有效数据个数
    private static final int DEFAULT_SIZE = 2;
    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }
    public MyArrayList(int initCapiacity){
        this.elem = new int[initCapiacity];

    }
    public  void display(){
        for(int i=0; i<this.usedSize; i++){
            System.out.println(this.elem[i]+" ");
        }
        System.out.println();

    }
    public void add(int data){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    public  boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return  false;
    }
    public  boolean contains(int toFind){
        for(int i=0; i<this.elem.length;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return  false;

    }
    public  int indexOf(int toFind){
        for(int i=0; i<this.elem.length;i++){
            if(this.elem[i]==toFind){
                return  i;
            }
        }
        return  -1;
    }
    public int get(int pos){
        checkPos(pos);
        return this.elem[pos];

    }
    public  void set(int pos ,int value) {
        checkPos(pos);
        this.elem[pos] = value;
    }
    private void checkPos(int pos){
        if(pos<0||pos>=usedSize){
            throw new  PosOutBoundsException(pos+"位置不合法");
        }
    }
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if (index == -1) {
            System.out.println("没有这个数据");
            return;
        }
        for (int i = index; i < this.elem.length; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }
    public  int size(){
        return  this.usedSize;
    }
    public void clear(){
        this.usedSize=0;
    }
}
