class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(cur > 0){
                max = max > 0 ? max * cur : cur;
                min = min < 0 ? min * cur : cur;
            } else {
                int temp = max;
                max = min < 0 ? min * cur : max < 0 ? max * cur : cur;
                min = temp > 0 ? temp * cur : min > 0 ? min * cur : cur;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
