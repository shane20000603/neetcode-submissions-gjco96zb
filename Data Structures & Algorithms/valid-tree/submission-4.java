class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        int find = -1;
        for(int ver = 0; ver < n; ver++){
                if(find != - 1 && uf.find(ver) != find) return false;
                find = uf.find(ver);
        }
        return true;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int size){
            parent = new int[size];        
            for(int i = 0; i < size; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                return find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return false;
            parent[px] = py;
            return true;
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}
