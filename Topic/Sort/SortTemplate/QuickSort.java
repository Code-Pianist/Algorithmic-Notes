package SortTemplate;

import java.util.Scanner;

/**
 * 快排模板
 */
public class QuickSort {
    /**
     * 模板1
     * @param arr
     * @param low
     * @param high
     */
    public static void QuickSort1(int[] arr,int low,int high){
        if(low >= high) return;
        int i = low-1,j = high+1,x = arr[low];
        while(i < j){
            do i++;while(arr[i] < x);
            do j--;while(arr[j] > x);
            if(i < j){ int t = arr[i];arr[i] = arr[j];arr[j] = t; }
        }
        QuickSort1(arr,low,j);
        QuickSort1(arr,j+1,high);
    }
    /**
     *模板2
     * @param arr
     * @param low
     * @param high
     */
    public static void QuickSort2(int[] arr, int low, int high){
        if (low < high) //递归跳出条件
        {
            int pivotpos = Partition(arr, low, high); //划分
            QuickSort2(arr, low, pivotpos-1 );        //递归划分左子表
            QuickSort2(arr,pivotpos+1, high);       //递归划分右子表
        }
    }
    public static int Partition(int[] arr,int low,int high){
        int pivot = arr[low]; //将第一个元素作枢轴
        while (low < high)    //用low，high搜索枢轴的最终位置
        {
            while (low < high && arr[high] >= pivot)    --high;
            arr[low] = arr[high]; //比枢轴小的元素左移
            while (low < high && arr[low] <= pivot)     ++low;
            arr[high] = arr[low]; //比枢轴大的元素右移
        }
        arr[low] = pivot; //枢轴元素放在最终位置
        return low;       //返回最终位置
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0;i < n;i++){
            arr1[i] = scanner.nextInt();
            arr2[i] = arr1[i];
        }
        QuickSort1(arr1,0,n-1);
        for (int num:arr1) {
            System.out.printf("%d ",num);
        }
        System.out.println();
        QuickSort2(arr2,0,n-1);
        for (int num:arr2) {
            System.out.printf("%d ",num);
        }

    }

}
