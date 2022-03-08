public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0 || n==0)    return 0;

        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;//有障碍则断路为0
                }else {
                    if(i==0 && j==0){
                        dp[i][j]=1;//base case 为1
                    }else {
                        dp[i][j] =0;//初始化
                        if(i>0){
                            dp[i][j] += dp[i-1][j];
                        }
                        if(j>0){
                            dp[i][j] += dp[i][j-1];
                        }
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}