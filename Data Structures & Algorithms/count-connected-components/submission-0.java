class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < n; i++){
            set.add(uf.find(i));
        }
        return set.size();
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

        private int find(int x){
            if(parent[x] != x){
                return find(parent[x]);
            }
            return x;
        }

        private void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(level[px] < level[py]){
                parent[px] = py;
            } else {
                parent[px] = py;
                if(level[px] == level[py]){
                    level[py]++;
                }
            }
        }
    }
}
