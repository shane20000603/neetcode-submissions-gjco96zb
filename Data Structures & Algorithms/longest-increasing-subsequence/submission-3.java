class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = i + 1; j < dp.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        for(int i = 0; i < dp.length; i++){System.out.println(dp[i]);}
        return res;
    }
}
