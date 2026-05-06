class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap();
        for(int[] course: prerequisites){
            List<Integer> courses = graph.getOrDefault(course[0], new ArrayList());
            courses.add(course[1]);
            graph.put(course[0], courses);
        }
        //0 represent not visited
        //1 visiting
        //2 visited

        boolean res = false;
        int[] status = new int[numCourses];
        for(int i: graph.keySet()){
            res = dfs(graph, i, status);
            if(!res) return false;
        }
        return true;
        
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, int index, int[] status){
        if(status[index] == 1){
            return false;
        }
        if(status[index] == 2){
            return true;
        }
        status[index] = 1;
        for(int pre: graph.getOrDefault(index, new ArrayList<Integer>())){
            if(!dfs(graph, pre, status)){
                return false;
            }
        }
        status[index] = 2;
        return true;
    }
}
