class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0)    return -1;
        int l = 0,r = nums.length-1;
        while(l < r){
            int mid = l+r >> 1;
            if(nums[mid]>=target)   r = mid;
            else    l = mid+1;
        }
        if(target > nums[nums.length-1])    return nums.length;
        return l;
    }
}