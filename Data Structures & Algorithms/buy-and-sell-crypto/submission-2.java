class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // 1. 前缀最小
        leftMin[0] = prices[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], prices[i]);
        }

        // 2. 后缀最大
        rightMax[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], prices[i]);
        }

        // 3. 计算最大利润
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, rightMax[i] - leftMin[i]);
        }

        return res;
    }
}