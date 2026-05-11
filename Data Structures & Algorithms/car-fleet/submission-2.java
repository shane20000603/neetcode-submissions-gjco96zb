class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //1 4   3 3
        //3 2
        //4 6
        //7 8
        //10 10

        //2 2 1 1
        //4 1 0 7. //3 5 10 3
        //6 3 1 8
        //8 5 2 9
        //10 7 3 10
        int[][] cb = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            cb[i][0] = position[i];
            cb[i][1] = speed[i];
        }
        Arrays.sort(cb, (a,b) -> b[0] - a[0]);
        Stack<Double> stack = new Stack();
        for(int[] car: cb){
            double time = (((double)target - car[0]) / car[1]);
            if(!stack.isEmpty()){
                if(time <= stack.peek()){
                    continue;
                }
            }
            stack.push(time);
        }
        return stack.size();
    }
}
