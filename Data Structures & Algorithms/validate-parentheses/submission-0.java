class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')','(');
        map.put('}','{');
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || !stack.peek().equals(map.get(c))){
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
