class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotting = new ArrayDeque<>();

        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = new int[grid[i].length];
            System.arraycopy(grid[i], 0, copy[i], 0, grid[i].length);
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == 2) rotting.offer(new int[]{i, j});
            }
        }

        int[][] dir = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
        };
        int duration = 0;
        while (!rotting.isEmpty()) {
            int size = rotting.size();
            while (size > 0) {
                int[] curr = rotting.poll();
                for (int i = 0; i < dir.length; i++) {
                    int newY = curr[0] + dir[i][0];
                    int newX = curr[1] + dir[i][1];
                    if (newY < 0 || newY >= grid.length || newX < 0 || newX >= grid[0].length || copy[newY][newX] != 1) continue;
                    copy[newY][newX] = 2;
                    rotting.offer(new int[]{newY, newX});
                }
                size--;
            }
            duration += !rotting.isEmpty() ? 1 : 0;
        }

        // find fresh oranges after rottening
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == 1) return -1;
            }
        }

        return duration;
    }
}
