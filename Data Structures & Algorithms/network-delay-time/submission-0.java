class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap();
        for(int[] time: times){
            int node = time[0];
            int d = time[1];
            int w = time[2];
            graph.computeIfAbsent(node, key -> new ArrayList<>()).add(new int[]{d, w});
        }

        int[] dist = new int[n + 1];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k] = 0;

        dfs(graph, dist, k, 0);

        int res = 0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            res=Math.max(res,dist[i]);
        }

        return res;

    }

    private void dfs(HashMap<Integer, List<int[]>> graph, int[] dist, int node, int cur){
        if(cur > dist[node]) return;
        List<int[]> neis = graph.get(node);
        if(!graph.containsKey(node)) return;
        for(int[] nei: neis){
            if(cur + nei[1] < dist[nei[0]]){
                dist[nei[0]] = cur + nei[1];
                dfs(graph, dist, nei[0], cur + nei[1]);
            }
        }
    }
}
