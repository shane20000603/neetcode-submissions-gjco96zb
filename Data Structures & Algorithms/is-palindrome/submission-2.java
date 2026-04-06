class Solution {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        List<Character> chars = new ArrayList();
        for(char c: lowerS.toCharArray()){
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9'){
                chars.add(c);
            }
        }
        int left = 0;
        int right = chars.size() - 1;
        while(left < right){
            if(chars.get(left) != chars.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
