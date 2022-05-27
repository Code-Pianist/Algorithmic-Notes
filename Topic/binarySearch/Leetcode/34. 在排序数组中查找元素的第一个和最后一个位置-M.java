class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums==null || nums.length==0)    return res;
        int l = 0,r = nums.length-1;
        while(l < r){
            int mid = l+r >> 1;
            if(nums[mid]>=target)   r = mid;
            else    l = mid+1;
        }
        if(nums[l]!=target) res[0] = -1;
        else res[0] = l;
        l = 0;r = nums.length-1;
        while(l < r){
            int mid = l+r+1 >> 1;
            if(nums[mid]<=target)   l = mid;
            else r = mid-1;
        }
        if(nums[l]!=target) res[1] = -1;
        else res[1] = l;

        return res;
    }
}