class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                } else if(sum > 0){
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                                    while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                }
            }
        }
        return res;
    }
}
