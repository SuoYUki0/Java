import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main1(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.display();




    }

    public static void main2(String[] args) {
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        for(int i=0;i< list2.size();i++){
            System.out.print(list2.get(i)+" ");


        }
        System.out.println();
        for(Integer x:list2){
            System.out.print(x+" ");
        }
        System.out.println();


    }
//    杨辉三角
//    1
//    1 1
//   1 2 1
//  1 3 3 1
//1 4 6 4 1
//
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret=new ArrayList<>();
        List<Integer> row=new ArrayList<>();
        row.add(1);
        ret.add(row);
        for(int i=1;i<numRows;i++)
        {
            List<Integer> curRow=new ArrayList<>();
            List<Integer> preRow=ret.get(i-1);
            curRow.add(1);
            for(int j=1;j<i;j++){
               int x= preRow.get(j-1)+ preRow.get(j);
               curRow.add(x);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return  ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret=generate(5);
        System.out.println(ret);
    }
}
