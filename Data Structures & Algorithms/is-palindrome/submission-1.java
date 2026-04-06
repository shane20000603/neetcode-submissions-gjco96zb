class Solution {
        public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {
        s = s.trim();
        int first = 0;
        int last = s.length() - 1;
        while(first < last){
            while(first < last && !alphaNum(s.charAt(first))){
                first++;
            }
            while(first < last && !alphaNum(s.charAt(last))){
                last--;
            }
            if(Character.toLowerCase(s.charAt(first))
             != Character.toLowerCase(s.charAt(last))){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
