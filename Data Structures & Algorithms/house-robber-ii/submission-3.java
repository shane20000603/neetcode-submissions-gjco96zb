class Solution {

    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length - 1];

        // case1: [0...n-2]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(
                dp[i - 1],
                dp[i - 2] + nums[i]
            );
        }

        int max = dp[dp.length - 1];

        // case2: [1...n-1]
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(
                dp[i - 1],
                dp[i - 2] + nums[i + 1]
            );
        }

        return Math.max(max, dp[dp.length - 1]);
    }
}