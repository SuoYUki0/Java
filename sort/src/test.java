import java.util.Arrays;
import java.util.Random;

public class test {
    public static void notOrderArrayRandom(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10_0000);
        }
    }
    public static void testInsertSort(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);

        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序耗时："+ (endTime-startTime));
        //System.out.println(Arrays.toString(tmpArray));
    }
    public static void testShellSort(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);

        long startTime = System.currentTimeMillis();
        Sort.shellSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时："+ (endTime-startTime));
        //System.out.println(Arrays.toString(tmpArray));
    }
    public static void testSelectSort(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时："+ (endTime-startTime));
        //System.out.println(Arrays.toString(tmpArray));
    }
    public static void testHeapSort(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时："+ (endTime-startTime));
        //System.out.println(Arrays.toString(tmpArray));
    }
    public static void testQuickSort(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时："+ (endTime-startTime));
        //System.out.println(Arrays.toString(tmpArray));
    }
    public static void testMergeSort(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序耗时："+ (endTime-startTime));
        //System.out.println(Arrays.toString(tmpArray));
    }

    public static void main(String[] args) {
        int[] array = new int[1_0000];
        notOrderArrayRandom(array);
        testShellSort(array);
        testInsertSort(array);
        testSelectSort(array);
        testHeapSort(array);
        testQuickSort(array);
        testMergeSort(array);
        int[] array2 = {1,21,32,4,5,8,10,9,8};
        testShellSort(array2);
        testInsertSort(array2);
        testSelectSort(array2);
        testHeapSort(array2);
        testQuickSort(array2);
        testMergeSort(array2);


    }
}
