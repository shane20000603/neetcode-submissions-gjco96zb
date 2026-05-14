class Solution {

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] min = new int[m][n];
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        for (int i = 0; i < m; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        min[0][0] = grid[0][0];
        //int[3] -> 0->x 1->y 2->w
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        queue.offer(new int[]{0,0,grid[0][0]});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            if(w > min[x][y]) continue;
            for(int[] direction: directions){
                int nx = x + direction[0];
                int ny = y + direction[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    int newCost = Math.max(grid[nx][ny], min[x][y]);
                    if(newCost < min[nx][ny]){
                        min[nx][ny] = newCost;
                        queue.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }
        return min[m - 1][n - 1];
    }
}
