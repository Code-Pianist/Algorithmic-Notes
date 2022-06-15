//n^2 前缀和
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int[] preSum =prefixSum(nums);
        for(int start = 0; start < n;start++){
            for(int end = start;end < n;end ++){
                if(preSum[end+1]-preSum[start] >= target){
                    minLength = Math.min(minLength,end-start+1);
                }
            }
        }
        if(minLength == Integer.MAX_VALUE)   return 0;
        return minLength;
    }

    int[] prefixSum(int[] nums){
        int[] preSum = new int[nums.length + 1];
        for(int i = 1;i <= nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        return preSum;
    }
}

//前缀和+二分nlogn
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int[] preSum = getPrefixSum(nums);
        for(int start = 0;start < n;start++){
            int end = getEnd(preSum,start,target);
            if(preSum[end+1]-preSum[start] >= target){
                minLength = Math.min(minLength,end-start+1);
            }
        }
        if(minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    int[] getPrefixSum(int[] nums){
        int[] preSum =new int[nums.length+1];
        for(int i = 1;i <= nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        return preSum;
    }

    int getEnd(int[] preSum,int start,int target){
        int left = start,right = preSum.length-2;
        while(left < right){
            int mid = left+right >> 1;
            if(preSum[mid+1]-preSum[start] >= target)   right = mid;
            else left = mid+1;
        }
        if(preSum[left+1]-preSum[start] >= target)  return left;
        return right;
    }
}
// n 同向双指针
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sumArray = 0,j = 0;
        for(int i = 0;i < n;i++){
            while(j < n && sumArray < target){
                sumArray += nums[j++];
            }
            if(sumArray >= target){
                minLength = Math.min(j-i,minLength);
            }
            sumArray -= nums[i];
        }
        if(minLength == Integer.MAX_VALUE)  return 0;
        return minLength;
    }
}
//n 滑动窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sumArray = 0;int left = 0;
        for(int right = 0;right < n;right++){
            sumArray += nums[right];
            while(left <= right && sumArray >= target){
                minLength = Math.min(minLength,right-left+1);
                sumArray-=nums[left++];
            }
        }
        if(minLength == Integer.MAX_VALUE)  return 0;
        return minLength;
    }
}