class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        boolean[] visited = new boolean[nums.length];
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            int len = 1;
            visited[i] = true;
            int minus = 1;
            while(map.containsKey(nums[i] - minus)){
                visited[map.get(nums[i] - minus)] = true;
                len++;
                minus++;
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
