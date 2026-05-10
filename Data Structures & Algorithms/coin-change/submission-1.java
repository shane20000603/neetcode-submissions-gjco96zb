class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[1];
        res[0] = -1;
        dfs(coins, amount, 0, 0, res);
        return res[0];
    }

    private void dfs(int[] coins, int amount, int index, int cur, int[] res){
        if(amount == 0){
            if(res[0] != -1)
            {res[0] = Math.min(cur, res[0]);}
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
