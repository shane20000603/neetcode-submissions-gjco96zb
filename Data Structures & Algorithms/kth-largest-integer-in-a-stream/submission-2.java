class KthLargest {

    private PriorityQueue<Integer> queue = new PriorityQueue();
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }      
        }
    }
    
    public int add(int val) {
            queue.offer(val);
            if(queue.size() > size){
                queue.poll();
            }     
            return queue.peek();
    }
}
