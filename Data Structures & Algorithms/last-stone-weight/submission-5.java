class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for(int stone: stones){
            queue.offer(stone);
        }
        while(queue.size() > 1){
            int prev = queue.poll();
            int head = queue.poll();
            if(prev != head){queue.offer(prev - head);}
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
