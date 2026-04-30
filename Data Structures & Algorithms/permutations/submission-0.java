class Solution {

    List<Integer> path = new ArrayList();
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
