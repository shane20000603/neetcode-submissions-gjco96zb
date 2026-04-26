class KthLargest {

    private PriorityQueue<Integer> queue = new PriorityQueue();
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        for(int i = 0; i < nums.length; i++){
            if(queue.size() == k){
                if(nums[i] > queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            } else {
                queue.offer(nums[i]);
            }
          
        }
    }
    
    public int add(int val) {
            if(queue.size() == size){
                if(val > queue.peek()){
                    queue.poll();
                    queue.offer(val);
                }
            } else {
                queue.offer(val);
            }
            return queue.peek();
    }
}
