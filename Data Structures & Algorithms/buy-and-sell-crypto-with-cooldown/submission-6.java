class Solution {
    // holding? yes [sell/not sell] -> d + 2
    // holding? no [buy/not buy] -> d + 1

    Map<String, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices) {
        int[] res = new int[1];
        dfs(prices, false, 0, 0, 0, res);
        return res[0];
    }

    private void dfs(int[] prices, boolean holding, int profit, int cost, int day, int[] res) {
        if (day >= prices.length) {
            res[0] = Math.max(res[0], profit);
            return;
        }

        String key = day + "_" + holding + "_" + cost;

        // 剪枝
        if (memo.containsKey(key) && memo.get(key) >= profit) {
            return;
        }

        memo.put(key, profit);

        if (holding) {
            if (prices[day] >= cost) {
                int curProfit = profit + prices[day] - cost;
                dfs(prices, false, curProfit, 0, day + 2, res);
            }
            dfs(prices, true, profit, cost, day + 1, res);
        } else {
            dfs(prices, true, profit, prices[day], day + 1, res);
            dfs(prices, false, profit, 0, day + 1, res);
        }
    }
}
