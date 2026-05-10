class Solution {

    public int maxProduct(int[] nums) {

        // 当前位置结尾的最大乘积
        int max = nums[0];

        // 当前位置结尾的最小乘积
        int min = nums[0];

        int ans = nums[0];

        for(int i = 1; i < nums.length; i++) {

            int num = nums[i];

            // 负数会导致最大最小互换
            if(num < 0) {

                int temp = max;
                max = min;
                min = temp;
            }

            // 要么重新开始
            // 要么接上之前
            max = Math.max(num, max * num);

            min = Math.min(num, min * num);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}