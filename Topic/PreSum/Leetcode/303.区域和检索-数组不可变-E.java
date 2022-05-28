class NumArray {
    private int[] res;
    public NumArray(int[] nums) {
        res = new int[nums.length+1];
        for(int i = 1;i < res.length;i++)
            res[i] = nums[i-1]+res[i-1];
    }

    public int sumRange(int left, int right) {
        return res[right+1]-res[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */