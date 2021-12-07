

### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

写树的相关算法，最重要的是搞清楚当前root节点的操作，然后孩子节点递归调用。

在本题中发现，它的实现类似前序遍历框架，先对当前结点操作，再依次递归

题解：通过观察，**我们发现只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树**。

### [116. 填充每个节点的下一个右侧节点指针 ](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)

[动画演示+三种实现 116. 填充每个节点的下一个右侧节点指针 - 填充每个节点的下一个右侧节点指针 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/)

法一：层序遍历

法二：前序递归遍历

该next连接时无非有两种情况，第一种为相同父节点的两节点，一种为相同祖父结点的两节点，因此可以将连接根节点的子节点变为连接连个相邻接点。



