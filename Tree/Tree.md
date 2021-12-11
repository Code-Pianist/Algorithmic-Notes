

### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

写树的相关算法，最重要的是搞清楚当前root节点的操作，然后孩子节点递归调用。

在本题中发现，它的实现类似前序遍历框架，先对当前结点操作，再依次递归

题解：通过观察，**我们发现只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树**。

### [116. 填充每个节点的下一个右侧节点指针 ](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)

[动画演示+三种实现 116. 填充每个节点的下一个右侧节点指针 - 填充每个节点的下一个右侧节点指针 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/)

法一：层序遍历

法二：前序递归遍历

该next连接时无非有两种情况，第一种为相同父节点的两节点，一种为相同祖父结点的两节点，因此可以将连接根节点的子节点变为连接连个相邻接点。

### [654. 最大二叉树 - 力扣](https://leetcode-cn.com/problems/maximum-binary-tree/)

**对于构造二叉树的问题，根节点要做的就是把想办法把自己构造出来**。

我们肯定要遍历数组把找到最大值`maxVal`，把根节点`root`做出来，然后对`maxVal`左边的数组和右边的数组进行递归调用，作为`root`的左右子树。

### [105. 从前序与中序遍历序列构造二叉树 - 力扣](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

![看图就明白了](https://labuladong.gitee.io/algo/images/%e4%ba%8c%e5%8f%89%e6%a0%91%e7%b3%bb%e5%88%972/4.jpeg)

