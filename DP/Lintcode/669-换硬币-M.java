public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount==0 || n==0)
            return 0;//base case
        int[] dp=new int[amount+1];
        dp[0] = 0;//边界
        for(int i = 1;i <= amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0;j < n;j++){
                if(i>=coins[j] && dp[i-coins[j]] !=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)   return -1;
        return dp[amount];
    }
}
/*
1.确定状态
last step：其中一种硬币+剩余最少硬币
2.转移方程
f[x]=min(f[x-coim[1]]+1,f[x-coim[2]]+1,f[x-coim[5]]+1);
3.初始和边界
amount!=0;
coins.length!=0;

f[0]=0;
4.计算顺序
f[x]需要f[a],a<x的值
*/