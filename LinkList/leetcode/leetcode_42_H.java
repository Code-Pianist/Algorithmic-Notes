//暴力
class Solution {
     public int trap(int[] height) {
         int h = height.length;
         int res = 0;
         for(int i = 1;i < h-1;i++){
             int l_max = 0,r_max = 0;
             for(int j = i;j>=0;j--){
                 l_max = Math.max(l_max,height[j]);
             }
             for(int j = i;j<h;j++){
                 r_max = Math.max(r_max,height[j]);
             }
             res+=Math.min(l_max,r_max)-height[i];
         }

         return res;
     }
 }//时间复杂度主要是重复查找最大值引起

//备忘录
 class Solution {
     public int trap(int[] height) {
         int h = height.length;
         int[] l_max = new int[h];
         int[] r_max = new int[h];
         l_max[0] = height[0];
         r_max[h-1] = height[h-1];
         for(int i = 1;i < h;i++){
             l_max[i] = Math.max(l_max[i-1],height[i]);
         }
         for(int i = h-2;i > -1;i--){
             r_max[i] = Math.max(r_max[i+1],height[i]);
         }
         int res = 0;
         for(int i = 1;i < h-1;i++){
             res += Math.min(l_max[i],r_max[i])-height[i];
         }

         return res;
     }
 }

//第i水位只取决于左右最高水柱的最小值，什么意思，就是说我只要知道，左边水柱低于右边水柱，就按左边计算，相同，右边一样
class Solution {
    public int trap(int[] height) {
        int h = height.length;
        if(h==0)    return 0;
        int left = 0,right = h-1;
        int l_max = 0,r_max = 0;
        int res = 0;
        while(left < right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);

            if(l_max < r_max){
                res += l_max-height[left];
                left++;
            }
            else{
                res += r_max-height[right];
                right--;
            }
        }
        return res;
    }
}