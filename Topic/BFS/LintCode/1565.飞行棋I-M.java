/**
 * 方法1：
 * BFS+BFS
 * 外层 BFS 做最短路径
 * 内层 BFS 找连通块
 */
public class Solution {
    /**
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        //1.构建连通图
        Map<Integer,Set<Integer>> graph = buildGraph(length,connections);
        //2.初始结点入队
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> distance = new HashMap<>();
        queue.offer(1);
        distance.put(1,0);
        while(!queue.isEmpty()){
            int now = queue.poll();
            //3.寻找下一步结点入队
            int limit = Math.min(now+6,length);
            for(int next = now+1;next <= limit;next++){
                //**与下一步结点直接相连的等效结点（BFS连通性判断）**
                List<Integer> arriveNodes = getArriveNodes(graph,distance,next);
                //下一步结点入队
                for(int arriveNode : arriveNodes){
                    queue.offer(arriveNode);
                    distance.put(arriveNode,distance.get(now)+1);
                }
            }
        }
        return distance.get(length);
    }
    //构建连通图
    Map<Integer,Set<Integer>> buildGraph(int length,int[][] connections){
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i = 1;i <= length; i++){
            graph.put(i,new HashSet<>());
        }
        for(int i = 0;i < connections.length;i++){
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
        }
        return graph;
    }
    //获得所有可达性结点
    List<Integer> getArriveNodes(Map<Integer,Set<Integer>> graph,
                                 Map<Integer,Integer> distance,int node){
        List<Integer> unVisitedNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(distance.containsKey(now))   continue;
            unVisitedNodes.add(now);
            for(int next : graph.get(now)){
                if(!distance.containsKey(next)){
                    queue.offer(next);
                    unVisitedNodes.add(next);
                }
            }
        }
        return unVisitedNodes;
    }
}
/**
 * 方法2：两个队列交替
 * 使用 BFS 实现中两个队列交替的方法
 * 将通过掷骰子跳到的点放在下一个队列里
 * 将通过直连到达的点放在当前队列里
 * 这样就不会破坏每个队列为同一层节点的属性
 */
public class Solution {
    /**
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        //1.构建连通图
        Map<Integer,Set<Integer>> graph = buildGraph(length,connections);
        //2.初始结点入队
        List<Integer> queue = new ArrayList<>();
        Map<Integer,Integer> distance = new HashMap<>();
        queue.add(1);
        distance.put(1,0);
        while(!queue.isEmpty()){
            //获取queue中所有结点的可达性(直接相连)结点
            for(int i = 0;i < queue.size();i++){
                int node = queue.get(i);
                for(int next : graph.get(node)){
                    if(distance.containsKey(next))  continue;
                    distance.put(next,distance.get(node));
                    queue.add(next);
                }
            }

            List<Integer> nextQueue = new ArrayList<>();
            for(int i = 0;i < queue.size();i++){
                int node = queue.get(i);
                int limit = Math.min(node+6,length);
                for(int next = node+1;next <= limit;next++){
                    if(distance.containsKey(next))  continue;
                    distance.put(next,distance.get(node)+1);
                    nextQueue.add(next);
                }
            }
            queue = nextQueue;
        }
        return distance.get(length);
    }
    //构建连通图
    Map<Integer,Set<Integer>> buildGraph(int length,int[][] connections){
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i = 1;i <= length; i++){
            graph.put(i,new HashSet<>());
        }
        for(int i = 0;i < connections.length;i++){
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
        }
        return graph;
    }
}

/**
 * SPFA
 * 一个节点是否被扔进队列的判断标准发生变化：
 * 简单图：没有访问过的点就扔进队列
 * 复杂图：如果到达该点的路径变短了就扔进队列
 */
public class Solution {
    /**
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        //1.构建连通图
        Map<Integer,Set<Integer>> graph = buildGraph(length,connections);
        //2.初始结点入队
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> distance = new HashMap<>();
        for(int i = 1;i <= length;i++){
            distance.put(i, Integer.MAX_VALUE);
        }
        queue.offer(1);
        distance.put(1,0);

        while(!queue.isEmpty()){
            //将所有路径变短的结点重新丢入队列
            int now = queue.poll();
            for(int next : graph.get(now)){
                if(distance.get(next) > distance.get(now)){
                    distance.put(next, distance.get(now));
                    queue.offer(next);
                }
            }

            int limit = Math.min(now+6,length);
            for(int next = now+1;next <= limit;next++){
                if(distance.get(next) > distance.get(now) +1){
                    distance.put(next,distance.get(now)+1);
                    queue.offer(next);
                }

            }
        }
        return distance.get(length);
    }
    //构建连通图
    Map<Integer,Set<Integer>> buildGraph(int length,int[][] connections){
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i = 1;i <= length; i++){
            graph.put(i,new HashSet<>());
        }
        for(int i = 0;i < connections.length;i++){
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
        }
        return graph;
    }
}

/**
 * 方法4：动态规划(DP)
 * state: dp[i] 表示从 i 出发跳到终点需要最少多少步
 * function: dp[i] = min(dp[j] + 1 or 0)
 * j 是 i 可以跳到或者直通的点, 跳过去的话步数+1，直通的话步数 + 0
 * initialization: dp[1..n-1] = oo, dp[n] = 0
 * answer: dp[1]
 */

public class Solution {
    /**
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        //1.构建连通图
        Map<Integer,Set<Integer>> graph = buildGraph(length,connections);
        int[] dp = new int[length+1];
        for(int i = 1;i <= length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[length] = 0;
        for(int i = length - 1;i >0;i--) {
            int limit = Math.min(i+6,length);
            //走一步到达点的最短路径
            for(int j = i+1;j <= limit;j++) {
                if(dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[j]+1);
            }
            //直接相连最短路径
            for(int j : graph.get(i)) {
                dp[i] = Math.min(dp[i],dp[j]);
            }
        }
        return dp[1];
    }
    //构建连通图
    Map<Integer,Set<Integer>> buildGraph(int length,int[][] connections){
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i = 1;i <= length; i++){
            graph.put(i,new HashSet<>());
        }
        for(int i = 0;i < connections.length;i++){
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
        }
        return graph;
    }
}