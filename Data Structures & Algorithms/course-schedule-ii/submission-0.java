class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        //init graph
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }

        //build graph
        for(int[] pres: prerequisites){
            int pre = pres[1];
            int after = pres[0];
            graph[pre].add(after);//after -> pre
            indegree[after]++;
        }

        //queue
        Queue<Integer> queue = new ArrayDeque();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList();

        while(!queue.isEmpty()){
            int cur = queue.poll();
            res.add(cur);
            for(int nei: graph[cur]){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        if(res.size() != numCourses) return new int[0];
        else return res.stream().mapToInt(Integer::intValue).toArray();

        
    }
}
