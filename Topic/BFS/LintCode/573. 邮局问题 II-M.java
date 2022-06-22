class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        int n = grid.length,m = grid[0].length;
        int minDist = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == GridType.EMPTY) {
                    Map<Integer,Integer> distance = bfs(grid,i,j);
                    minDist = Math.min(minDist,getDistanceSum(distance,grid));
                }
            }
        }
        return minDist != Integer.MAX_VALUE ? minDist :-1;
    }
    class GridType {
        static int EMPTY = 0;
        static int HOUSE = 1;
        static int WALL = 2;
    }

    int[] deltaX = {0,1,-1,0};
    int[] deltaY = {1,0,0,-1};
    Map<Integer,Integer> bfs(int[][] grid,int i,int j){
        int n = grid.length,m = grid[0].length;

        Map<Integer,Integer> distance = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i*m+j);
        distance.put(i*m+j,0);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / m,y = current % m;
            for (int dirction = 0;dirction < 4;dirction++) {
                int nextX = x + deltaX[dirction];
                int nextY = y + deltaY[dirction];
                int next = nextX*m +nextY;
                if(!isVaild(adjX,adjY,grid)) {
                    continue;
                }
                if(distance.containsKey(next)) {
                    continue;
                }
                distance.put(next,distance.get(current) +1);
                if(grid[nextX][nextY] != GridType.HOUSE) {
                    queue.add(next);
                }
            }
        }
        return distance;
    }

    boolean isVaild(int x,int y,int[][] grid) {
        int n = grid.length,m = grid[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return grid[x][y] ==GridType.EMPTY || grid[x][y] ==GridType.WALL;
    }

    int getDistanceSum(Map<Integer,Integer> distance,int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int distanceSum = 0;
        for(int x = 0;x < n;x++) {
            for(int y = 0;y < m;y++) {
                int val = grid[x][y];
                if(val == grid.HOUSE) {
                    if(!distance.containsKey(x*m+y)) {
                        return Integer.MAX_VALUE;
                    }
                    distanceSum += distance.get(x*m +y);
                }
            }
        }
        return distanceSum;
    }
}