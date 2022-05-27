package BinarySearchTemplate;

import java.util.Scanner;

public class BinarySearch {
    /**
     * 找出第一次出现位置，或者大于target第一个数
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch1(int[] arr,int target){
        int l = 0,r = arr.length-1;
        while(l < r){
            int mid = l+r >> 1;
            if(arr[mid] >= target)   r = mid;//大于等于target
            else    l = mid + 1;
        }
        if(arr[l] != target)    return -1;
        return l;
    }

    /**
     * 找出最后一次出现位置，或小于target的第一个数
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch2(int[] arr,int target){
        int l = 0,r = arr.length-1;
        while(l < r){
            int mid = l+r+1 >> 1;
            if(arr[mid] <= target)   l = mid;//小于等于target
            else    r = mid-1;
        }
        if(arr[l] != target)    return -1;
        return l;
    }

    /**
     * 浮点数二分，开根号
     * @param target
     * @return
     */

    public static double binarySearch3(double target){
        double eps = 1e-8;//比要求的精度小两位
        double l = 0,r = target;
        while(r-l > eps){
            double mid = (l+r)/2;
            if(mid * mid >= target) r = mid;
            else    l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++)    {arr[i] = scanner.nextInt();}
        int target = scanner.nextInt();
        System.out.println("第一次出现位置：-->"+binarySearch1(arr,target));
        System.out.println("最后一次出现位置：-->"+binarySearch2(arr,target));
        double target1 = scanner.nextDouble();
        System.out.printf("%f",binarySearch3(target1));
    }

}
