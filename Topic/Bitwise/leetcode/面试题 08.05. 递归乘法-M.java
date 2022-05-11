class Solution {
    public int multiply(int A, int B) {
        if(A > B)   multiply(B,A);
        if(A == 1)  return B;
        if(A %2 == 0)   return multiply(A>>1,B)<<1;
        else    return ((multiply(A>>1,B)<<1)+B);
    }
}