class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Cell> queue = new LinkedList<>(); 

        queue.offer(new Cell(entrance[0], entrance[1], 0));
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        visited[entrance[0]][entrance[1]] = true;
        int[] dirRow = {1, -1, 0, 0};
        int[] dirCol = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();


            if (isExit(curr, maze) && curr.dist() != 0) {
                return curr.dist();
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row() + dirRow[i];
                int nextCol = curr.col() + dirCol[i];
                Cell nextCell = new Cell(nextRow, nextCol, curr.dist() + 1);
                if (!isWall(nextCell, maze) && !visited[nextRow][nextCol]) {
                    queue.offer(nextCell);
                    
                    visited[nextCell.row()][nextCell.col()] = true;
                }
            }

        }

        return -1;

    }

    private boolean isExit(Cell cell, char[][] maze) {
        return !isWall(cell, maze) && (cell.row() == 0 || cell.col() == 0 || cell.row() == maze.length - 1 || cell.col() == maze[0].length -1);
    }

    private boolean isWall(Cell cell, char[][] maze) {
        return cell.row() < 0 || cell.row() >= maze.length || cell.col() < 0 || cell.col() >= maze[0].length || maze[cell.row()][cell.col()] == '+';
    }

    public record Cell(int row, int col, int dist){}
}
