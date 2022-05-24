class Solution {
    public int findNthDigit(int n) {
        long start = 1;int digits = 1;
        while(n > 9*start*digits){
            n -= 9*start*digits;
            start *=10;
            digits++;
        }
        long num = start+(n-1)/digits;
        return Long.toString(num).charAt((n - 1) % digits) - '0';
    }
}