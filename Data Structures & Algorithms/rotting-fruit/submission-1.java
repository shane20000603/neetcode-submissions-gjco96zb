class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int row = grid.length;
        int col = grid[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2){
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
                if(grid[nr][nc] == 1) {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        int res = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                System.out.print(grid[r][c] + ", ");
                if(grid[r][c] == 1) return -1;
                res = Math.max(res, grid[r][c] - 2);
            }
            System.out.println();
        }
        return res;
    }
}
