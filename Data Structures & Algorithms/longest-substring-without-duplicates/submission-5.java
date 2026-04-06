class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        HashSet<Character> set = new HashSet();
        int left = 0;
        int right = 0;
        int res = 1;
        set.add(s.charAt(left));
        while(right < s.length()){
            if(set.contains(s.charAt(right))){
                while(left < right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            } else {
                set.add(s.charAt(right));
                res = Math.max(res, set.size());
            }
            right++;
        }
        return res;
    }
}
