class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for(int[] point: points){
            queue.offer(point);
            if(queue.size() > k){
                queue.poll();
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        while(!queue.isEmpty()){
            int[] cur = res[index];
            int[] node = queue.poll();
            cur[0] = node[0];
            cur[1] = node[1];
            index++;
        }
        return res;
    }
}
