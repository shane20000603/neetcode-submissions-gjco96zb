class MinStack {

    class Pair{
        int val;
        int min;
        public Pair(int val){
            this.val = val;
        }
    }

    Stack<Pair> stack = new Stack();

    public MinStack() {
        
    }
    
    public void push(int val) {
        Pair pair = new Pair(val);
        if(stack.isEmpty()){
            pair.min = val;
        } else {
            pair.min = Math.min(val, stack.peek().min);
        }
        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
