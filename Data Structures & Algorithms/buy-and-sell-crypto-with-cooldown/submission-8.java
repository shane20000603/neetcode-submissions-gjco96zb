class Solution {

    public int maxProfit(int[] prices) {

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {

            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            // 持有
            hold = Math.max(
                prevHold,
                prevRest - prices[i]
            );

            // 今天卖
            sold = prevHold + prices[i];

            // 休息
            rest = Math.max(
                prevRest,
                prevSold
            );
        }

        return Math.max(sold, rest);
    }
}