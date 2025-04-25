

public class Sort {
    /**
     * 时间复杂度：
     *      最好情况：数据完全有序的时候 1 2 3 4 5 ：O(N)
     *      最坏情况：数据完全逆序的时候 5 4 3 2 1 ：O(N^2)
     *  结论：当所给的数据 越有序 排序 越快。
     *  场景：现在有一组基本有序的数据，那么你用哪个排序好点？
     *
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     *    一个本身就是稳定的排序  是可以实现为不稳定的排序的
     *    但是相反 一个本身就不稳定的排序  是不可能实现为稳定的排序的
     *    1 3 5 2 4
     * @param array
     */
    public static void insertSort(int[] array){
        for(int i=1;i< array.length;i++){
            int tmp=array[i];
            int j=i-1;
            while (j>=0){
                if(array[j]>tmp){
                    array[j+1]=array[j];
                    j--;
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    /**
     * 时间复杂度：
     *     n^1.3 - n^1.5
     * 复杂度：O(1)
     *
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void shellSort(int[] array){
        int gap= array.length;
        while(gap>1){
            gap/=2;
            shell(array,gap);
        }
    }
    private static void shell(int[] array,int gap){
        for(int i=gap;i<array.length;i++){
            int tmp=array[i];
            int j=i-gap;
            while(j>=0){
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                    j-=gap;
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    /**
     * 选择排序：
     *     时间复杂度：不管最好还是最坏 都是O(n)
     *     时间复杂度：不管最好还是最坏 都是O(n^2)
     *     空间复杂度：O(1)
     *     稳定性：不稳定的排序
     * @param array
     */
    public static void selectSort(int[] array){
        for(int i=0;i< array.length;i++){
            int minIndex=i;
            for (int j = i+1; j < array.length ; j++) {
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }

            }
            swap(array,minIndex,i);
        }
    }
    private static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    /**
     * 时间复杂度：
     *          O(n*logN)        N^1.3 -->
     * 空间复杂度：O(1)
     * 稳定性：不稳定的
     *    数据量非常 大的时候 堆排 一定比希尔快
     * @param array
     */
    public static void heapSort(int[] array){
        createBigHeap(array);
        int end= array.length-1;
        while (end>0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }
    private static void createBigHeap(int[] array){
        for(int parent=(array.length-1-1)/2;parent>=0;parent--){
            shiftDown(array,parent,array.length);
        }
    }
    private static void shiftDown(int[] array,int parent,int end){
        int child=2*parent+1;
        while (child<end){
            if(child+1<end&&array[child+1]>array[child]){
                child++;
            }
            if(array[child]>array[parent]){
                swap(array,child,parent);
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }

    }
    /**
     * 冒泡排序：
     *  时间复杂度： o(n^2)   如果加了优化  最好情况O(N)
     *  空间复杂度：
     *  稳定性：
     *  空间复杂度：O(1)
     *  稳定性：稳定的排序
     * @param array
     */
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean flg=false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flg=true;
                }

            }
            if(!flg){
                return;
            }

        }
    }
    /**
     * 时间复杂度：
     *      最好情况:
     *              O(N*logN)   满二叉树/完全二叉树
     *      最坏情况:
     *            O(N^2) 单分支的树
     * 空间复杂度：
     *   最好情况:
     *           O(logN)   满二叉树/完全二叉树
     *  最坏情况:
     *          O(N)   单 分支的树
     * 稳定性：不稳定
     * @param array
     */
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    private static void quick(int[] array,int start,int end){
        if(start>=end) return;
        int pivot=partition(array,start,end);
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }
    private static int partition(int[] array,int left,int right){
        int key=array[left];
        int i=left;
        while (left<right){
            while (left<right&&array[right]>=key){
                right--;
            }
            while (left<right&&array[left]<=key){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,i);
        return left;
    }
    private static int partition2(int[] array,int left,int right){
        int key=array[left];
        while (left<right){
            while (left<right&&array[right]>=key){
                right--;
            }
            array[left]=array[right];
            while (left<right&&array[left]<=key){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=key;
        return left;
    }
    /**
     * 时间复杂度： 0(N*logN)
     * 空间复杂度：O(n)
     * 稳定性: 稳定
     *      插入排序   冒泡    归并
     * @param array
     */
    public static void mergeSort(int[] array){
        mergeSortFuunc(array,0,array.length-1);
    }
    private static void mergeSortFuunc(int[] array,int left,int right){
        if(left>right){
            return;
        }
        int mid=(left+right)/2;
        mergeSortFuunc(array,left,mid);
        mergeSortFuunc(array,mid,right);
        merge(array,left,right,mid);
    }
    private static void merge(int[] array,int left,int right,int mid){
        int s1=left;
        int s2=mid+1;
        int[] tmpArr=new int[right-left+1];
        int k=0;
        while (s1<=mid&&s2<=right){
            if(array[s2] <= array[s1]) {
                tmpArr[k++] = array[s2++];
            }else {
                tmpArr[k++] = array[s1++];
            }
        }
        while (s1 <= mid) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= right) {
            tmpArr[k++] = array[s2++];
        }
        //tmpArr 里面一定是这个区间内有序的数据了
        for (int i = 0; i < tmpArr.length; i++) {
            array[i+left] = tmpArr[i];
        }
    }

}
