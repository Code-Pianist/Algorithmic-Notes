class Solution {
// public int rob(int[] nums) {
//     return dp(nums, 0);
// }
// // 返回 nums[start..] 能抢到的最大值
// private int dp(int[] nums, int start) {
//     if (start >= nums.length) {
//         return 0;
//     }

//     int res = Math.max(
//             // 不抢，去下家
//             dp(nums, start + 1),
//             // 抢，去下下家
//             nums[start] + dp(nums, start + 2)
//         );
//     return res;
// }

    //  int rob(int[] nums) {
//     int n = nums.length;
//     // dp[i] = x 表示：
//     // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
//     // base case: dp[n] = 0
//     int[] dp = new int[n + 2];
//     for (int i = n - 1; i >= 0; i--) {
//         dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
//     }
//     return dp[0];
// }
    int rob(int[] nums) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dp_i_1 = 0, dp_i_2 = 0;
        // 记录 dp[i]
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}