class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for(String str: tokens){
            if(str.equals("+") || str.equals("-") ||
            str.equals("*") || str.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
                if(str.equals("+")) res = a + b;
                else if(str.equals("-")) res = b - a;
                else if(str.equals("*")) res = b * a;
                else res = b / a;

                stack.push(res);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
