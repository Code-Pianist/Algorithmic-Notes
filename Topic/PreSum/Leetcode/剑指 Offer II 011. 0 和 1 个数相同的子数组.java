class Solution {
    public int findMaxLength(int[] nums) {
        int sum= 0,maxLength = 0;
        HashMap<Integer,Integer> sum2index = new HashMap<>();
        sum2index.put(0,-1);

        int n = nums.length;
        for(int i = 0;i < n;i++){
            int num = nums[i];
            if(num == 1)    sum++;
            else sum--;
            if(sum2index.containsKey(sum)){
                int len = i-sum2index.get(sum);
                maxLength = Math.max(maxLength,len);
            }else   sum2index.put(sum,i);
        }
        return maxLength;
    }
}