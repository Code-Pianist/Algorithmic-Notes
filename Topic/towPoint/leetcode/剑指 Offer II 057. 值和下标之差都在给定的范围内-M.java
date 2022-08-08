class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
         // 特殊情况
        if(nums.length < 2 || k == 0) return false;

        // 保存长度为k的窗口内的数
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            // 由于 cur - floor 可能会出现溢出情况，所以用 Long 来表示
            long cur = nums[i];
            // 获取比 cur 小的数中最接近 cur 的数
            Long floor = treeSet.floor(cur);
            // 获取比 cur 大的数中最接近 cur 的数
            Long ceiling = treeSet.ceiling(cur);
            // 如果窗口中最接近 cur 的数 与 cur 的差 <= t, 说明存在这样的两个数，返回 true
            if(floor != null && cur - floor <= t) return true;
            if(ceiling != null && ceiling - cur <= t) return true;
            // 将当前数添加到窗口中
            treeSet.add(cur);
            // 剔除窗口最右边的元素
            if(i >= k) treeSet.remove(Long.valueOf(nums[i - k]));
        }
        return false;
    }
}