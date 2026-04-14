class Solution {
    public boolean isValidSudoku(char[][] board) {
        // brute force
        // O(n.m^3)
        // space O(1)
        // m = num of row = num of col = num of subboxes

        // memorization (hashmap)
        // map: number -> list of coord
        // O(n), worst case O(n.log n)
        // O(n)


        // 3 map
        // 1st map: number -> row -> boolean
        // 2nd map: number -> column -> boolean
        // 3rd map: number -> subbox index -> boolean
        // time: O(n)
        // space: O(m^3)
        // m = num of row = num of col = num of subboxes

        Map<Character, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;

                if (!map.containsKey(board[i][j])) {
                    List<Pair> coords = new ArrayList<>();
                    coords.add(new Pair(i, j));
                    map.put(board[i][j], coords);
                    continue;
                }

                List<Pair> prevCoords = map.get(board[i][j]);

                for (Pair coord : prevCoords) {
                    
                    // check row
                    if (coord.x() == i) return false;

                    // check col
                    if (coord.y() == j) return false;

                    // check subbox
                    if (determineSubbox(i, j).equals(determineSubbox(coord.x(), coord.y()))) return false;
                }

                prevCoords.add(new Pair(i, j));
            }
        }
        return true;
    }

    private String determineSubbox(int x, int y) {
        int subboxRow = x / 3;
        int subboxCol = y / 3;
        return subboxRow + "." + subboxCol;
    }

    private record Pair(int x, int y) {}
}


