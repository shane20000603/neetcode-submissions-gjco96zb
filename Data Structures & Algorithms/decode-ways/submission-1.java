class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int size = s.length();
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for(int i = 1; i < size + 1; i++){
            if(chars[i - 1] != '0'){
                dp[i] += dp[i - 1];
            }
            if(i >= 2){
                int together = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
                if(together >= 10 && together <= 26){
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[size];
    }
}
