class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                left[i] = 1;
            } else {
                left[i] = nums[i - 1] * left[i - 1];
            }
        }
        int[] right = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            if(i == nums.length - 1){
                right[i] = 1;
            } else {
                right[i] = nums[i + 1] * right[i + 1];
            }
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = right[i] * left[i];
        }
        return res;
    }
}  
