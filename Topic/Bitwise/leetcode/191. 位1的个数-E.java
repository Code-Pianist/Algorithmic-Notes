public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int tmp = n,count = 0;
        while(tmp != 0){
            tmp &=(tmp-1);
            count++;
        }
        return count;
    }
}