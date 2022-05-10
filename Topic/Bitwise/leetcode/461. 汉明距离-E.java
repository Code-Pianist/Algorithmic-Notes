/**
 *异或后，不同位一定为1.再统计1的个数
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while(xor != 0){
            xor &=(xor-1);
            count++;
        }
        return count;
    }
}