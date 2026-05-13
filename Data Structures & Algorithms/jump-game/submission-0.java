class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0, nums[0]);
    }

    private boolean dfs(int[] nums, int startIndex, int max){
        if(startIndex >= nums.length - 1){
            return true;
        }
        if(nums[startIndex] == 0){
            return false;
        }
        for(int i = startIndex + 1; i <= max + startIndex; i++){
            if(dfs(nums, i, nums[i])){
                return true;
            }
        }
        return false;
    }
}
