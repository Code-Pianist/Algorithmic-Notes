 class Solution {//求公共前缀,注意java有符号位，所以最高位不用
     public int rangeBitwiseAnd(int left, int right) {
         int stan = 1 << 30;
         int res = 0;
         while(stan>0 && (left&stan)==(right&stan)){
             res |=left&stan;
             stan>>=1;
         }
         return res;
     }
 }

class Solution {//求公共前缀,消去不同的1
    public int rangeBitwiseAnd(int left, int right) {
        int count=0;
        while(right > left){
            right &=(right-1);
            count++;
        }
        return right;
    }
}
