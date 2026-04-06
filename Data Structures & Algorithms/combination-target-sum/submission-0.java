class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backTracking(nums, target, 0, 0);
        return res;
    }

    private void backTracking(int[] nums, int target, int index, int curSum){
        if(curSum > target){
            return;
        }
        if(curSum == target){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = index; i < nums.length; i++){        
            curSum += nums[i];
            path.add(nums[i]);
            backTracking(nums, target, i, curSum);
            path.remove(path.size() - 1);
            curSum -= nums[i];
        }
        // index++;
    }
}
