class Solution {

    List<String> res = new ArrayList();

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap();
        //init
        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue());
            graph.get(from).offer(to);
        }
        //
        dfs("JFK", graph);
        return res;
    }

    private void dfs(String from, HashMap<String, PriorityQueue<String>> graph){
        PriorityQueue<String> queue = graph.get(from);
        while(queue != null && !queue.isEmpty()){
            String dest = queue.poll();
            dfs(dest, graph);
        }
        res.addFirst(from);
    }
}
