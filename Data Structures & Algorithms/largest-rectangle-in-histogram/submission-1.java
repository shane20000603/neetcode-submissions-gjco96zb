class Solution {
    public int largestRectangleArea(int[] heights) {
        //7 1 1 1 1 1 1 1 1
        //

        //4 5 2 2

        Stack<int[]> stack = new Stack();
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] pop = stack.pop();
                res = Math.max(res, pop[1] * (i - pop[0]));
                start = pop[0];
            } 
            stack.push(new int[]{start, heights[i]});
            
        }
        int n = heights.length;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();

            res = Math.max(
                res,
                pop[1] * (n - pop[0])
            );
        }
        return res;
    }
}
