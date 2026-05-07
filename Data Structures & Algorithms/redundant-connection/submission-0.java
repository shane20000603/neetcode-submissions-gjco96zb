class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        UnionFind uf = new UnionFind(size + 1);
        for(int[] edge: edges){
            if(uf.find(edge[0]) == uf.find(edge[1])){
                return edge;
            } else uf.union(edge[0], edge[1]);
        }
        return new int[]{};
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
            if(level[px] > level[py]){
                parent[py] = px;
            } else {
                parent[px] = py;
                if(level[px] == level[py]){
                    level[py]++;
                }
            }
        }
    }
}
