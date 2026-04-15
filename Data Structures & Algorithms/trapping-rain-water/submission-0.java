class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i = 0; i < left.length; i++){
            if(i == 0) {
                left[i] = 0;
            } else{
                left[i] = Math.max(left[i - 1], height[i - 1]);
            }
        }
        for(int i = right.length - 1; i >=0; i--){
            if(i == right.length - 1){
                right[i] = 0;
            } else {
                right[i] = Math.max(right[i + 1], height[i + 1]);
            }
        }
        int res = 0;
        for(int i = 0; i < height.length; i++){
            res += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return res;
    }
}
