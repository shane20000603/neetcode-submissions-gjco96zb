class Solution {
    // apple pen
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + ", ");
        }
        return dp[s.length()];
    }
}
