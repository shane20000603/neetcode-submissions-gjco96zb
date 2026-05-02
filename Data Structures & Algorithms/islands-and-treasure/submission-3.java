class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    dfs(grid, r, c, 0, new boolean[rows][cols]);
                }
            }
        }
    }

    private void dfs(int[][] grid, int row, int col, int step, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) return;
        if(grid[row][col] == 0 && step != 0 || grid[row][col] == -1) return;
        if(grid[row][col] < step) return;
        grid[row][col] = step;
        visited[row][col] = true;
        step++;
        dfs(grid, row + 1, col, step, visited);
        dfs(grid, row - 1, col, step, visited);
        dfs(grid, row, col + 1, step, visited);
        dfs(grid, row, col - 1, step, visited);
        visited[row][col] = false;
    }
}
