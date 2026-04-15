class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        String res = "";
        if(len1 < len2) return "";
        int left = 0;
        Map<Character, Integer> map = new HashMap();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) - 1);
        }
        int diff = map.keySet().size();
        for(int right = 0; right < len1; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                int num = map.get(c);
                map.put(c, num + 1);
                if(num + 1 == 0) diff--;
            } 
            if(diff == 0){
                if(res.length() == 0 || res.length() > right - left + 1){
                    res = s.substring(left, right + 1);
                }
            }
            while(diff == 0 && left <= right){
                char leftC = s.charAt(left);
                if(map.containsKey(leftC)){
                int cNum = map.get(leftC);
                map.put(leftC, cNum - 1);
                if(cNum - 1 < 0){
                    diff++;
                }}
                if(res.length() == 0 || res.length() > right - left + 1){
                    res = s.substring(left, right + 1);
                }
                left++;
            }
        }
        return res;
    }
}
