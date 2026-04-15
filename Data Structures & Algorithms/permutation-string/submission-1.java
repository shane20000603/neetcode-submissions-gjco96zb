class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2 < len1) return false;
        int left = 0;
        int right = len1 - 1;
        int[] diff = new int[26];
        for(int i = 0; i < len1; i++){
            diff[s1.charAt(i) - 'a']--;
            diff[s2.charAt(i) - 'a']++;
        }
        while(right < s2.length() - 1){
            if(!same(diff)){
                diff[s2.charAt(left) - 'a']--;
                left++;
                right++;
                diff[s2.charAt(right) - 'a']++;
            } else {
                return true;
            }
        }
        return same(diff);
    }

    private boolean same(int[] arr){
        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
