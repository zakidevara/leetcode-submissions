class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        // Iterate through every city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        // Mark the current city as visited
        visited[i] = true;
        
        // Check connections to all other cities
        for (int j = 0; j < isConnected.length; j++) {
            // If city i is connected to city j, and we haven't visited j yet
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
