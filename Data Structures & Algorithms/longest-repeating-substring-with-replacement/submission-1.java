class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int left = 0;
        int[] count = new int[26];
        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'A']++;
            while((left < right) && (right - left + 1 - maxValueInArray(count) > k)){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    private int maxValueInArray(int[] arr){
        int max = 0;
        for(int i: arr){
            max = Math.max(i, max);
        }
        return max;
    }
}
