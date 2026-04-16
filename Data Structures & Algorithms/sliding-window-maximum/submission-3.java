class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque();
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && i - k >= deque.peekFirst()){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1){
                res[index] = nums[deque.peekFirst()];
                index++;
            }
        }
        return res;
    }
}
