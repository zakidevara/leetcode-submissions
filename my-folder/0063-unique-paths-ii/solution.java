class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        if (obstacleGrid[m-1][n-1] != 0 || obstacleGrid[0][0] != 0) return 0;

        Queue<Coord> queue = new ArrayDeque<>();
        queue.offer(new Coord(m-1, n-1));
        obstacleGrid[m-1][n-1] = -1;
        Set<Coord> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Coord curr = queue.poll();
            if (visited.contains(curr)) continue;
            visited.add(curr);

            // update the unique path to get to the finish from this point
            if (curr.x+1 < m && obstacleGrid[curr.x+1][curr.y] < 1) 
                obstacleGrid[curr.x][curr.y] += obstacleGrid[curr.x+1][curr.y];
                
            if (curr.y+1 < n && obstacleGrid[curr.x][curr.y+1] < 1) 
                obstacleGrid[curr.x][curr.y] += obstacleGrid[curr.x][curr.y+1];

            // populate queue
            if (curr.x-1 >= 0 && obstacleGrid[curr.x-1][curr.y] < 1) 
                queue.offer(new Coord(curr.x-1, curr.y));
                
            if (curr.y-1 >= 0 && obstacleGrid[curr.x][curr.y-1] < 1) 
                queue.offer(new Coord(curr.x, curr.y-1));
        }

        return obstacleGrid[0][0] * -1;
    }

    public record Coord(int x, int y) {}
}
