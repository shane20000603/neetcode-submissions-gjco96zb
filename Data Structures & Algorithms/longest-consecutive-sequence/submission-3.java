class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet();
        for(int n: nums){
            set.add(n);
        }
        int max = 1;
        for(int n: nums){
            if(set.contains(n - 1)) continue;
            int len = 1;
            int cur = n;
            while(set.contains(++cur)){
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
