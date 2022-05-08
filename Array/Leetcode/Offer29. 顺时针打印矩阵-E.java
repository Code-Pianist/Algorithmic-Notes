class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)   return new int[0];
        int l = 0;int r = matrix[0].length-1;int t = 0;int b = matrix.length-1;
        int x = 0;
        int[] res = new int[(r+1)*(b +1)];
        while(true){
            //从左往右
            //列在变，列为循环值
            //从左往右的下一步是往下走，上边界内缩，故++t
            for(int i = l;i <= r;i++)    res[x++] = matrix[t][i];
            if(++t > b) break;
            for(int i = t;i <= b;i++)    res[x++] = matrix[i][r];
            if(--r < l) break;
            for(int i = r;i >= l;i--)    res[x++] = matrix[b][i];
            if(--b < t) break;
            for(int i = b;i >= t;i--)    res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }
}


