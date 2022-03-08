public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i==0 || j==0)
                    dp[i][j]=1;
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

/**分析
 1.确定状态
 f[m][n]=f[m-1][n]+f[m][n-1];
 2.状态方程
 3.初始及边界
 m,n>0

 f[0][0]=1;不是零
 4.计算顺序
 先行后列（只能往下和右，所以先算行）
 */