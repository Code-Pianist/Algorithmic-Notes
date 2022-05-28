# PreSum前缀和

## 笔记一：preSum

#### 一维前缀和(默认A[1~i],preSum[1~i])

preSum[i] = preSum[i-1] + A[i];//init

A[l]+A[l+1]+...+A[r] = preSum[r] - preSum[l-1];//求和，注意为preSum【l-1】

#### 二维前缀和

preSum[i] [j] = preSum[i-1] [j] + preSum[i] [j-1] + A[i] [j] - preSum[i-1] [j-1];//init

(x1,y1,x2,y2)矩阵和 = S[x2] [y2] - S[x1-1] [y2] - S[x2] [y1-1] + S[x1-1] [y1-1];//求和

## 题目

[剑指 Offer II 011. 0 和 1 个数相同的子数组 ](https://leetcode.cn/problems/A1NYOS/)

解:[0 和 1 个数相同的子数组 - 0 和 1 个数相同的子数组 ](https://leetcode.cn/problems/A1NYOS/solution/0-he-1-ge-shu-xiang-tong-de-zi-shu-zu-by-xbyt/)

将数组元素0看为-1，即找相同个数0和1的连续子数组，变为找和为0的连续子数组。

[303. 区域和检索 - 数组不可变 - 力扣](https://leetcode.cn/problems/range-sum-query-immutable/)

[304. 二维区域和检索 - 矩阵不可变 - 力扣](https://leetcode.cn/problems/range-sum-query-2d-immutable/)

## 笔记二：差分