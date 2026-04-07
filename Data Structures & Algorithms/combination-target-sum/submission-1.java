class Solution {
    List<List<Integer>> res = new ArrayList();
    List<Integer> path = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTracking(nums, target, 0);
        return res;
    }

    private void backTracking(int[] nums, int left, int index){
        if(left < 0 || index >= nums.length){
            return;
        }
        if(left == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(nums[index]);
        backTracking(nums, left - nums[index], index);
        path.remove(path.size() - 1);
        backTracking(nums, left, index + 1);
    }
}
