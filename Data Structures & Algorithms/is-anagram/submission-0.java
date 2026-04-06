class Solution {
    public boolean isAnagram(String s, String t) {
        int[] smap = new int[26];
        for(char c: s.toCharArray()){
            smap[c - 'a']++;
        }
        for(char c: t.toCharArray()){
            smap[c - 'a']--;
        }
        for(int i: smap){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
