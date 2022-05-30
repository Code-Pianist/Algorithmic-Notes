class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        for(int[] trip : trips) {
            nums[trip[1]] +=trip[0];
            if(trip[2]<=1001)
                nums[trip[2]] -=trip[0];
        }
        if(nums[0] > capacity)  return false;
        for(int i = 1;i < 1001;i++){
            nums[i] +=nums[i-1];
            if(nums[i] > capacity)  return false;
        }
        return true;
    }
}