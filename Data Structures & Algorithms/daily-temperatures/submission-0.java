class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<int[]> stack = new Stack();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int[] peek = stack.pop();
                res[peek[1]] = i - peek[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
