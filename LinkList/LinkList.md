#### [328. 奇偶链表 - 力扣](https://leetcode-cn.com/problems/odd-even-linked-list/)

打眼一看：双指针，嗯。

#### [42. 接雨水 - 力扣](https://leetcode-cn.com/problems/trapping-rain-water/)

water[i] = min(
        *# 左边最高的柱子*
        max(height[0..i]), 
        *# 右边最高的柱子*
        max(height[i..end]) 
      ) - height[i]

**暴力法**：时间复杂度n^2,主要耗费在对l_max，r_max的重复查找，想一想，有没有办法一次性解决查找，哎对，备忘录

**备忘录**

**双指针**：既然当前节点接水量取决于左右最大水柱的较小量，假设left点水柱小于right水柱，及时右边水柱不一定是最高的，但是你既然都小于右边，右边小于等于右边最大水柱，那么你依然水柱相对较小。完美

#### [19. 删除链表的倒数第 N 个结点 - 力扣](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

#### [剑指 Offer 06. 从尾到头打印链表 - 力扣](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
