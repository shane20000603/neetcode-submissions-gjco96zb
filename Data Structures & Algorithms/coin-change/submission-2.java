class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i <= amount; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int c: coins){
                if(i - c >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        if(dp[amount] != amount + 1) return dp[amount];
        else return -1;
    }

    private void dfs(int[] coins, int amount, int index, int cur, int[] res){
        if(amount == 0){
            if(res[0] != -1){
                res[0] = Math.min(cur, res[0]);
            }
            else res[0] = cur;
            return;
        }
        if(amount < 0 || index >= coins.length){
            return;
        }
        int curCoin = coins[index];
        dfs(coins, amount - curCoin, index, cur + 1, res);
        dfs(coins, amount, index + 1, cur, res);
    }
}
