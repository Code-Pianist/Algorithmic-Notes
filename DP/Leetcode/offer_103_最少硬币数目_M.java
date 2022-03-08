class Solution {
    public int coinChange(int[] coins, int amount) {
        //init
        if(amount<1)    return 0;
        if(coins.length==0) return 0;

        int[] dp =  new int[amount+1];
        Arrays.fill(dp,amount+1);
        //base case
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){//acount sequence
            for(int k = 0;k < coins.length;k++){
                if(i >= coins[k]){
                    dp[i] = Math.min(dp[i-coins[k]]+1,dp[i]);//dp
                }
            }
        }
        if(dp[amount]==amount+1)    return -1;
        return dp[amount];
    }
}