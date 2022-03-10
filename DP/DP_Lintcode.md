### 669 · 换硬币-M

[669 · 换硬币 - LintCode](https://www.lintcode.com/problem/669/description)

```
1.确定状态
last step：其中一种硬币+剩余最少硬币
2.转移方程
f[x]=min(f[x-coim[1]]+1,f[x-coim[2]]+1,f[x-coim[5]]+1);
3.初始和边界
amount!=0;
coins.length!=0;

f[0]=0;
4.计算顺序
f[x]需要f[a],a<x的值
```

### 114 · 不同的路径-E

[114 · 不同的路径 - LintCode](https://www.lintcode.com/problem/114/description)

```
/**分析
1.确定状态
f[m][n]=f[m-1][n]+f[m][n-1];
2.状态方程
3.初始及边界
m,n>0

f[0][0]=1;不是零
4.计算顺序
先行后列（只能往下和右，所以先算行）
*/
```

### 116 · 跳跃游戏-M

[114 · 不同的路径 - LintCode](https://www.lintcode.com/problem/114/description)

```
/**分析
1.确定状态
f[m][n]=f[m-1][n]+f[m][n-1];
2.状态方程
3.初始及边界
m,n>0

f[0][0]=1;不是零
4.计算顺序
先行后列（只能往下和右，所以先算行）
*/
```

### 115 · 不同的路径 II

[115 · 不同的路径 II - LintCode](https://www.lintcode.com/problem/115/)

### 515 · 房屋染色

[515 · 房屋染色 - LintCode](https://www.lintcode.com/problem/515/)

```
/*分析：序列性动态规划
思路：暴力遍历前i的所有颜色及花费
1.确定状态：
  1>子结构：
​    在染色第n个房子,需要知道前n-1个房子的价格和第n-1个房子颜色
​    在染色前n-1个房子，同上。
  2>变量
2.状态转移方程
  颜色1：dp[i][0] = min{dp[i-1][1]+color[1],dp[i-1][2]+color[2]}
  颜色2：同上
3.初始化及base case
  base：dp[0][0]=dp[0][1]=dp[0][2] = 0;
​      dp[0]:第0动房
4.顺序
*/

//贪心：从左至右依次选择最少的花费颜色，保证不重复，但是结果不一定对少。
```

### 512 · 解码方法

[512 · 解码方法 - LintCode](https://www.lintcode.com/problem/512/description)
