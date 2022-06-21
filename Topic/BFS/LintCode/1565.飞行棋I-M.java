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
            //3.获得所有可达性结点
            int limit = Math.min(now+6,length);
            for(int next = now+1;next <= limit;next++){
                List<Integer> arriveNodes = getArriveNodes(graph,distance,next);
                for(int arriveNode : arriveNodes){
                    //4.所有可达性结点全部入队
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