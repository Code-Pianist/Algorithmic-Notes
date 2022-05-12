// class Solution {
//     public int minArray(int[] numbers) {
//         for(int i = 0,j = i+1;i < numbers.length -1;i++,j++){
//             if(numbers[i]>numbers[j])   return numbers[j];
//         }
//         return numbers[0];
//     }
// }

class Solution {
    public int minArray(int[] numbers) {
        int left = 0,right = numbers.length-1;
        int mid;
        while(left < right){
            mid = left + (right -left)/2;
            if(numbers[mid] > numbers[right])   left = mid+1;
            else if(numbers[mid] < numbers[right]) right = mid;
            else  right--;
        }
        return numbers[left];
    }
}