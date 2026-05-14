class Solution {
    // t -> x,y
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);
        boolean[][] can = new boolean[n][n];
        int[][] map = new int[n*n][2];
        int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[grid[i][j]][0] = i;
                map[grid[i][j]][1] = j;
            }
        }

        for(int t = 0; t < n*n; t++){
            int x = map[t][0];
            int y = map[t][1];
            can[x][y] = true;
            for(int[] dir: dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(can[nx][ny]){
                    uf.union(grid[nx][ny], grid[x][y]);
                }
            }
            if(uf.isConnected(grid[0][0], grid[n - 1][n - 1])){
                return t;
            }
        }
        return -1;
    }

    class UnionFind {
        int[] parent;
        int[] level;
        public UnionFind(int size) {
            parent = new int[size];
            level = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                level[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                return find(parent[x]);
            }
            return x;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (level[px] < level[py]) {
                parent[px] = py;
            } else {
                if (level[px] == level[py]) {
                    level[px]++;
                }
                parent[py] = px;
            }
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}
