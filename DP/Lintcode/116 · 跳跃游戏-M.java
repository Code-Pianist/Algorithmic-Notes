public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        if(A.length==0) return false;
        boolean[] step = new boolean[A.length];
        step[0] = true;
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < A.length;j++){
                if(step[i] && A[i]+i >=j){
                    step[j] = true;
                }
            }
        }
        return step[A.length-1];
    }
}
/**
 1.确定状态
 最后一个位置为第i个位置跳跃到达，因此需要满足：
 1>第i个位置可到达
 2>i+A[i]>=j
 2.转移方程
 i+a[i]>=j
 3.初始及边界
 数组非零
 4.计算
 从第一个位置开始

 */