class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(!stack.isEmpty() && (c == ']' && stack.peek() == '[' || 
            c == '}' && stack.peek() == '{' || 
            c == ')' && stack.peek() == '(')){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    } 
}
