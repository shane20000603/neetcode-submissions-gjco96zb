class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 0){ 
                    queue.offer(new int[]{r,c});
                }
            }
        }
        int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                if(grid[nr][nc] != Integer.MAX_VALUE) continue;

                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
