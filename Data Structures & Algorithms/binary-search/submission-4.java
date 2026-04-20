class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length - 1);
    }

    private int binary(int[] nums, int target, int left, int right){
        if(left == right) return nums[left] == target ? left : -1;
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        int mid = left + (right - left)/2;
        if(nums[left] > target || nums[right] < target) return -1;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target){
            return binary(nums, target, left, mid - 1);
        } else {
            return binary(nums, target, mid + 1, right);
        }
    }
}
