public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n==0)    return 0;//init

        int[][] dp = new int[n+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;//base case

        for(int i = 1;i <= n;i++){
            //j is color of now
            for(int j = 0;j < 3;j++){
                dp[i][j] = Integer.MAX_VALUE;
                //k is color of last
                for(int k = 0;k < 3;k++){
                    if(j == k) continue;

                    if(dp[i][j] > dp[i-1][k]+costs[i-1][j]){
                        dp[i][j] = dp[i-1][k]+costs[i-1][j];
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < 3;i++){
            res = Math.min(dp[n][i],res);
        }
        return res;
    }
}
/*分析：序列性动态规划
思路：暴力遍历前i的所有颜色及花费
1.确定状态：
    1>子结构：
        在染色第n个房子,需要知道前n-1个房子的价格和第n-1个房子颜色
        在染色前n-1个房子，同上。
    2>变量
2.状态转移方程
    颜色1：dp[i][0] = min{dp[i-1][1]+color[1],dp[i-1][2]+color[2]}
    颜色2：同上
3.初始化及base case
    base：dp[0][0]=dp[0][1]=dp[0][2] = 0;
            dp[0]:第0动房
4.顺序

*/

//贪心：从左至右依次选择最少的花费颜色，保证不重复，但是结果不一定对少。
// public class Solution {
//     /**
//      * @param costs: n x 3 cost matrix
//      * @return: An integer, the minimum cost to paint all houses
//      */
//     public int minCost(int[][] costs) {
//         int n = costs.length;
//         if(n==0)    return 0;//init

//         int[][] dp = new int[n+1][2];
//         dp[0][0] = dp[0][1]  = 0;//base case

//         for(int i = 1;i<=n;i++){
//             int cost = Integer.MAX_VALUE;
//             int color = 0;
//             for(int j = 0;j < 3;j++){
//                 if(dp[i-1][1]==j && i>1)   continue;
//                 if(cost > costs[i-1][j]){
//                     cost = costs[i-1][j];
//                     color = j;
//                 }
//             }
//             dp[i][0] = dp[i-1][0]+cost;
//             dp[i][1] = color;
//         }

//         return dp[n][0];
//     }
// }