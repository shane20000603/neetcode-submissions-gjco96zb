class Solution { 
    // 9 1 4 2 3 3 7
    // dp -> min value of lenth i
    // 9 3 5 2 3
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int num: nums){
            int left = 0;
            int right = list.size();
            while(left < right){
                int mid = left + (right - left)/2;
                if(list.get(mid) < num){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if(left == list.size()){
                list.add(num);
            } else {
                list.set(left, num);
            }
            
        }
        return list.size();
    }
}
