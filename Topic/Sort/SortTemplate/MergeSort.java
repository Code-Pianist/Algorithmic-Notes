package SortTemplate;

public class MergeSort {
    public static void mergeSort(int[] arr,int low,int high){
        if(low >= high) return;

        int mid =(low +high) >>1;
        mergeSort(arr, low, mid);
        mergeSort(arr,mid+1,high);
        Merge(arr,low,mid,high);
    }
    public static void Merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[arr.length];
        for(int i = low;i <= high;i++)    temp[i] = arr[i];

        int i = low,j = mid+1,k = i;
        while(i <= mid && j <= high){
            if(temp[i] <= temp[j])  arr[k++] = temp[i++];
            else    arr[k++] = temp[j++];
        }

        while(i <= mid) arr[k++] = temp[i++];
        while(j <= high)    arr[k++] = temp[j++];
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr1 = new int[n];
//        for(int i = 0;i < n;i++){
//            arr1[i] = scanner.nextInt();
//        }
        int[] arr1 ={4,2,3,2,34,2,3,2,4,2,3};
        mergeSort(arr1,0, arr1.length-1);
        for (int num:arr1) {
            System.out.printf("%d ",num);
        }
    }
}
