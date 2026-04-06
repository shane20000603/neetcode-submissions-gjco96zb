class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int left = 0;
        int right = 1;
        int res = 0;
        while(right < prices.length){
            if(prices[right] < prices[left]){
                left = right;
            } else {
                res = Math.max(res, prices[right] - prices[left]);
            }
            right++;
        }

        return res;
    }
}