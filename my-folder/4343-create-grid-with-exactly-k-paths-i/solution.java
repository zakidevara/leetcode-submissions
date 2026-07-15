class Solution {
    public String[] createGrid(int m, int n, int k) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        calculateDP(dp);
        
        System.out.println(Arrays.deepToString(dp));

        int diff = dp[dp.length-1][dp[0].length-1]-k;
        if (diff == 0) {
            return convertToStringArray(dp);
        }

        boolean isValid = placeObstacle(dp, k);

        return isValid ? convertToStringArray(dp) : new String[0];
    }

    private void calculateDP(int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    }

    private boolean placeObstacle(int[][] dp, int target) {
        int m = dp.length;
        int n = dp[0].length;
        
        int currentPaths = countPaths(dp);
        if (target > currentPaths) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Never block the start or end cells
                if ((i == 0 && j == 0) || (i == m - 1 && j == n - 1)) {
                    continue;
                }
                
                int originalValue = dp[i][j];
                dp[i][j] = 0; // Try placing an obstacle
                
                currentPaths = countPaths(dp);
                
                if (currentPaths >= target) {
                    // Keep the obstacle, it safely reduced or maintained paths
                    if (currentPaths == target) {
                        return true; 
                    }
                } else {
                    // Revert the obstacle, it removed too many paths
                    dp[i][j] = originalValue;
                }
            }
        }
        
        return countPaths(dp) == target;
    }

    // HELPER: Accurately counts valid paths given the current obstacles
    private int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];
        temp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= 0) continue; // Cell is blocked
                
                if (i > 0) temp[i][j] += temp[i-1][j];
                if (j > 0) temp[i][j] += temp[i][j-1];
            }
        }
        return temp[m-1][n-1];
    }

    private String[] convertToStringArray(int[][] grid) {
        String[] res = new String[grid.length];
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }

            res[i] = sb.toString();
        }

        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length || col == grid[0].length) return 0;
        if (row == grid.length-1 && col == grid[0].length - 1) {
            grid[row][col]++;
            return 1;
        };
        int numPathDown = dfs(grid, row+1, col);
        int numPathRight = dfs(grid, row, col+1);

        grid[row][col] += numPathDown + numPathRight;

        return numPathDown + numPathRight;
    }
}
