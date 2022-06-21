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