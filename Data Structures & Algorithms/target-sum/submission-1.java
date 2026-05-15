class Solution {

    HashMap<String, Integer> map = new HashMap();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int index){
        if(index >= nums.length){
            return target == 0 ? 1 : 0;
        }
        String key = index+"_"+target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int add = dfs(nums, target + nums[index], index + 1);
        int minus = dfs(nums, target - nums[index], index + 1);

        map.put(key, add + minus);

        
        return add + minus;
    }
}
