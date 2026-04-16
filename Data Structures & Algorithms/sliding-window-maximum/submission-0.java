class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        int index = 0;
        while(right < nums.length){
            res[index] = findMax(nums, left, right);
            index++;
            left++;
            right++;
        }
        return res;
    }

    public int findMax(int[] arr, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
