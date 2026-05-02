class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(!visited[r][c] && grid[r][c] == 1){
                    int[] cur = dfs(grid, r, c, new int[]{0}, visited);
                    max = Math.max(cur[0], max);
                }
            }
        }
        return max;
    }

    private int[] dfs(int[][] grid, int r, int c, int[] res, boolean[][] visited){
        if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0
        || grid[r][c] != 1 || visited[r][c]) return res;
        visited[r][c] = true;
        res[0]++;
        dfs(grid, r + 1, c, res, visited);
        dfs(grid, r - 1, c, res, visited);
        dfs(grid, r, c + 1, res, visited);
        dfs(grid, r, c - 1, res, visited);
        return res;
    }
}
