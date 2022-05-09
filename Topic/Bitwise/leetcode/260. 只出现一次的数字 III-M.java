class Solution {
    public int[] singleNumber(int[] nums) {
        int xor_sum = 0;
        for(int i : nums)   xor_sum ^=i;

        int num1 = 0,num2 = 0;
        int bit = 1;
        while((xor_sum & 1)==0){//找出第一个为1的二进制位数，以此将原数组分为两部分
            xor_sum >>=1;
            bit <<=1;
        }
        for(int i : nums){
            if((i & bit)==0)    num1 ^=i;
            else num2 ^=i;
        }
        return new int[]{num1,num2};
    }
}