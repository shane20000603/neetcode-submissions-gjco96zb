class Solution {
    public int rob(int[] nums) {
         if(nums.length == 1) return nums[0];
        return Math.max(robInRange(nums, 0, nums.length - 2), 
        robInRange(nums, 1, nums.length - 1));
    }

    private int robInRange(int[] nums, int left, int right){
        int prev1 = 0;
        int prev2 = 0;
        for(int i = left; i <= right; i++){
            int cur = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = cur;
        }
        return prev2;
    }
}
