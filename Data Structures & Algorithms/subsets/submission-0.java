class Solution {

    List<List<Integer>> res = new ArrayList();
    List<Integer> path = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index){
        if(index == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(nums[index]);
        dfs(nums, index + 1);
        path.remove(path.size() - 1);
        dfs(nums, index + 1);
    }
}
