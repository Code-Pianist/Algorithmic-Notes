class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null ||matrix.length ==0 ) return false;
        int i = 0,j = matrix[0].length-1;
        while(i < matrix.length && j >-1){
            if(target > matrix[i][j]) i++;
            else if(target < matrix[i][j]) j--;
            else return true;
        }
        return false;
    }
}