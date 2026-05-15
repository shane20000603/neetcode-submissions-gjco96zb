class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i - coin];
            }
        }
        for(int i = 0; i < amount + 1;i++){
            System.out.print(dp[i] + ", ");
        }
        return dp[amount];
    }
}
