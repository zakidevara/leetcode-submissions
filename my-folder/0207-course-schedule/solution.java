class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            adj.get(pair[0]).add(pair[1]);
        }

        // loop through each node in the adjacency list. Do DFS on each of them to check for cycles

        // state to track: 0 = unvisited, 1 = visited in the curr stack, 2 = visited
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] != 0) continue;
            boolean hasCycle = hasCycle(adj, state, i);
            if (hasCycle) return false;
        }


        // if cycle not found, return true

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] state, int currNode) {
        state[currNode] = 1;

        // loop through the neighbours to do dfs and detect cycle
        for (Integer neighbour : adj.get(currNode)) {
            if (state[neighbour] == 1) return true;
            if (state[neighbour] == 0) {
                boolean hasCycle = hasCycle(adj, state, neighbour);
                if (hasCycle) return true;
            }
        }

        state[currNode] = 2;
        return false;
    }

}
