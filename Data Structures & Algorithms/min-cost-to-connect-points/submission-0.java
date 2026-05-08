class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> graph = new ArrayList();
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] first = points[i];
                int[] second = points[j];
                graph.add(new int[]{i, j, distance(first, second)});
            }
        }
        //by distance increasing
        Collections.sort(graph, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(points.length);
        int res = 0;
        for(int[] edge: graph){
            if(uf.find(edge[0]) == uf.find(edge[1])){
                continue;
            } else {
                uf.union(edge[0], edge[1]);
                res += edge[2];
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        int[] level;

        public UnionFind(int size){
            parent = new int[size];
            level = new int[size];
            for(int i = 0; i < size; i++){
                parent[i] = i;
                level[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                return find(parent[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(level[px] < level[py]){
                parent[px] = py;
            } else {
                parent[py] = px;
                if(level[px] == level[py]){
                    level[px]++;
                }
            }
        }
    }

    private int distance(int[] x, int[] y){
        return (int)Math.abs(x[0] - y[0]) + (int)Math.abs(x[1] - y[1]);
    }
}
