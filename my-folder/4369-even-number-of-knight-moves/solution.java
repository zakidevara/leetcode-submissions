class Solution {
    public boolean canReach(int[] start, int[] target) {
        int moveCount = minKnightMoves(start, target);
        return moveCount != -1 && moveCount % 2 == 0;
    }

    private int minKnightMoves(int[] start, int[] target) {
        if (start[0] == target[0] && start[1] == target[1]) return 0;

        int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, 
                        {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[8][8]; 

        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if (curr[0] == target[0] && curr[1] == target[1]) {
                    return moves;
                }

                for (int[] dir : dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    
                    
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            moves++; 
        }

        return -1; 
    }
}
