/**
 * 顺序数组可以使用二分查找。
 原数组为部分顺序数组，那就找出分界点，依次查找
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length -1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] <= nums[r])    r = mid;
            else l = mid+1;
        }//找分界点
        int pl = l,pr = l;
        l = 0;r = nums.length -1;
        while(l < pl){
            int mid = l+pl >>1;
            if(nums[mid] >= target) pl = mid;
            else l = mid+1;
        }//查左
        if(nums[l]==target) return l;

        while(pr < r){
            int mid = pr+r >> 1;
            if(nums[mid] >= target) r = mid;
            else pr = mid+1;
        }//查右
        if(nums[pr]==target) return pr;

        return -1;
    }
}