class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;  // 买入点
        int right = 1; // 卖出点

        int maxProfit = 0;

        while (right < prices.length) {
            // 如果当前更低 → 更新买入点（窗口左边界移动）
            if (prices[right] < prices[left]) {
                left = right;
            } else {
                // 否则计算利润
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }

            right++;
        }

        return maxProfit;
    }
}