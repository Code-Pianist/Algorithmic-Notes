public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        if(n==0)   return 0;

        int[] dp = new int[n+1];
        dp[0] = 1;
        int k,m;
        for(int i =1;i <=n;i++){
            m = str[i-1]-'0';
            if(m>0 && m < 10){
                dp[i] += dp[i-1];
            }
            if(i>1){
                k = (str[i-2]-'0')*10+m;
                if(k>9 && k<27){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[n];
    }
}