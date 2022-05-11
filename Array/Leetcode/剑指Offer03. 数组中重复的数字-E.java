// class Solution {
//     public int findRepeatNumber(int[] nums) {
//         Set<Integer> hashSet = new HashSet<>();
//         for(int num:nums){
//             if(hashSet.contains(num))   return num;
//             hashSet.add(num);
//         }
//         return -1;
//     }
// }
/**
 遍历数组 numsnums ，设索引初始值为 i = 0i=0 :

 若 nums[i] = inums[i]=i ： 说明此数字已在对应索引位置，无需交换，因此跳过；
 若 nums[nums[i]] = nums[i]nums[nums[i]]=nums[i] ： 代表索引 nums[i]nums[i] 处和索引 ii 处的元素值都为 nums[i]nums[i] ，即找到一组重复值，返回此值 nums[i]nums[i] ；
 否则： 交换索引为 ii 和 nums[i]nums[i] 的元素值，将此数字交换至对应索引位置。
 若遍历完毕尚未返回，则返回 -1−1 。
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length,i = 0;
        while(i < len){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[nums[i]]==nums[i])  return nums[i];
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;

        }

        return -1;
    }
}