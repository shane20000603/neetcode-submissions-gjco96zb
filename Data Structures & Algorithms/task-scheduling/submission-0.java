class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char c : tasks){
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        for(int f : freq){
            if(f > 0){
                pq.offer(f);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            while(cycle > 0 && !pq.isEmpty()){

                int cur = pq.poll();

                if(cur - 1 > 0){
                    temp.add(cur - 1);
                }

                time++;
                cycle--;
            }

            for(int remain : temp){
                pq.offer(remain);
            }

            // 还有任务没做完，需要补 idle
            if(!pq.isEmpty()){
                time += cycle;
            }
        }

        return time;
    }
}